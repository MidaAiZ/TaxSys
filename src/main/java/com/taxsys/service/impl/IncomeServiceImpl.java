package com.taxsys.service.impl;

import com.taxsys.dao.impl.IncomeDaoImpl;
import com.taxsys.dto.IncomeDto;
import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Income;
import com.taxsys.model.Income;
import com.taxsys.service.IncomeService;
import com.taxsys.utils.MD5Util;
import com.taxsys.utils.ReadExcel;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeDaoImpl incomeDao;

    public List<Income> readExcelFile(MultipartFile file) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<Income> incomeList = readExcel.getExcelInfo(file, "income");
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        if(incomeList != null){
            try{
                for(Income i : incomeList) {
                    String incomeId = UUIDGeneratorUtil.getUUID();
                    i.setId(incomeId);
                    incomeDao.createIncome(i);
                };
                return incomeList;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
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
        if (incomeDao.getIncomeByTaxId(income.getTaxId()) != null) {
            createIncomeDto = new IncomeDto(false, "进项已存在");
            return createIncomeDto;
        }

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
        if(oldIncome.getTaxId() != income.getTaxId()) {
            oldIncome.setTaxId(income.getTaxId());
        }
        if(oldIncome.getInType() != income.getInType()) {
            oldIncome.setInType(income.getInType());
        }
        if(oldIncome.getMoney() != 0 && oldIncome.getMoney() != (income.getMoney())) {
            oldIncome.setMoney(income.getMoney());
        }
        if(oldIncome.getCreated_at() != null && !oldIncome.getCreated_at().equals(income.getCreated_at())) {
            oldIncome.setCreated_at(income.getCreated_at());
        }
        if(!incomeDao.updateIncomeInfo(oldIncome)) {
            return new IncomeDto(false, "更新进项信息失败");
        }
        return new IncomeDto(true, oldIncome);    }

    public List<String> searchIncomeList(Map<String, Object> params){ return incomeDao.searchIncomeList(params); }

    public List<String> typeList() {
        return incomeDao.typeList();
    };

    }
