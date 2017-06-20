package com.taxsys.service.impl;

import com.taxsys.dao.impl.IncomeDaoImpl;
import com.taxsys.dto.IncomeDto;
import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Income;
import com.taxsys.model.Income;
import com.taxsys.model.User;
import com.taxsys.service.IncomeService;
import com.taxsys.utils.MD5Util;
import com.taxsys.utils.ReadExcel;
import com.taxsys.utils.TimeUtil;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.*;

import static java.lang.System.out;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeDaoImpl incomeDao;

    public Map<String, Object> readExcelFile(MultipartFile file, User user) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        Map<String, Object> resultMap = new HashMap();

        try {
            List<Income> incomeList = readExcel.getExcelInfo(file, "income");
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,

            if (incomeList.size() == 1 && incomeList.get(0).equals("ERROR FILE")) {
                resultMap.put("error", "文件格式错误！");
            } else if (incomeList != null) {
                List successList = new LinkedList(); // 添加成功的进项
                List failList = new LinkedList(); // 添加失败的进项

                try {
                    for (Income i : incomeList) {
                        i.setUid(user.getId());
                        try {
                            IncomeDto incomeDto = createIncome(i);
                            if (incomeDto.isSuccess()) {
                                successList.add(incomeDto.getIncome());
                            } else {
                                Map failMap = new HashMap<String, Object>();
                                failMap.put("error", incomeDto.getMessage());
                                failMap.put("income", i);
                                failList.add(failMap);
                            }
                        } catch (Exception e) {
                            Map failMap = new HashMap<String, Object>();
                            failMap.put("error", e.toString());
                            failMap.put("income", i);
                            failList.add(failMap);
                        }
                    };
                    resultMap.put("successList", successList);
                    resultMap.put("failList", failList);
                } catch (Exception e) {
                    resultMap.put("error", e.toString());
                }
            } else {
                resultMap.put("error", "没有导入任何数据！");
            }
        }catch(Exception e) {
            resultMap.put("error", "文件格式错误！");
        } finally {
            return resultMap;
        }
    }

    public Income getIncome(String id) {
        return incomeDao.getIncome(id);
    }

    public Income getIncomeByTaxId(String taxId) {
        return incomeDao.getIncomeByTaxId(taxId);
    }

    public List<Income> getIncomes() {
        return incomeDao.getIncomes();
    }

    @Transactional
    public IncomeDto createIncome(Income income) {
        IncomeDto createIncomeDto;

        // 进项查重
        if (income.getTaxId().length() != 0 && incomeDao.getIncomeByTaxId(income.getTaxId()) != null) {
            createIncomeDto = new IncomeDto(false, "进项已存在");
            return createIncomeDto;
        }

        // 完善进项信息
        String incomeId = UUIDGeneratorUtil.getUUID();
        income.setId(incomeId);

        String now = TimeUtil.now();
        income.setCreated_at(now);
        income.setUpdated_at(now);

        // 插入数据库失败
        if (!incomeDao.createIncome(income)) {
            createIncomeDto = new IncomeDto(false, "创建失败");
            return createIncomeDto;
        }

        // 成功创建
        createIncomeDto = new IncomeDto(true, income);
        return createIncomeDto;
    }

    public IncomeDto modifyIncomeInfo(Income income) {
        Income oldIncome = incomeDao.getIncome(income.getId());
        if(oldIncome == null) {
            return new IncomeDto(false, "进项不存在");
        }
        oldIncome.setTaxId(income.getTaxId());
        oldIncome.setInType(income.getInType());
        oldIncome.setMoney(income.getMoney());
        oldIncome.setTaxDate(income.getTaxDate());
        oldIncome.setCreated_at(income.getCreated_at());
        oldIncome.setUpdated_at((income.getUpdated_at()));
        if(!incomeDao.updateIncomeInfo(oldIncome)) {
            return new IncomeDto(false, "更新进项信息失败");
        }
        return new IncomeDto(true, oldIncome);
    }

    public IncomeDto createIncomeForce(Income income, User user) {
        String now = TimeUtil.now();
        income.setCreated_at(now);
        income.setUpdated_at(now);
        income.setUid(user.getId());
        Income oldIncome = incomeDao.getIncomeByTaxId(income.getTaxId());
        if(oldIncome != null) {
            income.setId(oldIncome.getId());
            return modifyIncomeInfo(income);
        } else {
            return createIncome(income);
        }
    }

    public List<String> searchIncomeList(Map<String, Object> params){ return incomeDao.searchIncomeList(params); }

    public List<String> typeList() {
        return incomeDao.typeList();
    };

    }
