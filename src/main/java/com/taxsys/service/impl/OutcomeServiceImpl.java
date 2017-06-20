package com.taxsys.service.impl;

import com.taxsys.dao.impl.OutcomeDaoImpl;
import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Outcome;
import com.taxsys.model.User;
import com.taxsys.service.OutcomeService;
import com.taxsys.utils.ReadExcel;
import com.taxsys.utils.TimeUtil;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    OutcomeDaoImpl outcomeDao;

    public Map<String, Object> readExcelFile(MultipartFile file, User user) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        Map<String, Object> resultMap = new HashMap();
        try{
            //解析excel，获取上传的事件单
            List<Outcome> outcomeList = readExcel.getExcelInfo(file, "outcome");
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,

            if (outcomeList.size() == 1 && outcomeList.get(0).equals("ERROR FILE")) {
                resultMap.put("error", "文件格式错误！");
            } else if (outcomeList != null){
                List successList = new LinkedList(); // 添加成功的进项
                List failList = new LinkedList(); // 添加失败的进项

                try{
                    String now = TimeUtil.now();

                    for(Outcome i : outcomeList) {
                        i.setUid(user.getId());
                        try {
                            OutcomeDto outcomeDto = createOutcome(i);
                            if(outcomeDto.isSuccess()){
                                successList.add(outcomeDto.getOutcome());
                            } else {
                                Map failMap = new HashMap<String, Object>();
                                failMap.put("error", outcomeDto.getMessage());
                                failMap.put("outcome", i);
                                failList.add(failMap);
                            }
                        } catch (Exception e) {
                            Map failMap = new HashMap<String, Object>();
                            failMap.put("error", e.toString());
                            failMap.put("outcome", i);
                            failList.add(failMap);
                        }
                    };
                    resultMap.put("successList", successList);
                    resultMap.put("failList", failList);
                } catch (Exception e) {
                    resultMap.put("error", e.toString());
                }
            }else{
                resultMap.put("error", "没有导入任何数据！");
            }
        } catch (Exception e) {
            resultMap.put("error", "文件格式错误！");
        } finally {
            return resultMap;
        }
    }


    public Outcome getOutcome(String id) {
        return outcomeDao.getOutcome(id);
    }

    public Outcome getOutcomeByTaxId(String taxId) {
        return outcomeDao.getOutcomeByTaxId(taxId);
    }

    public LinkedList<Outcome> getOutcomes() {
        return outcomeDao.getOutcomes();
    }

    @Transactional
    public OutcomeDto createOutcome(Outcome outcome) {
        OutcomeDto createOutcomeDto;

        // 销项查重
        if (outcome.getTaxId().length() != 0 && outcomeDao.getOutcomeByTaxId(outcome.getTaxId()) != null) {
            createOutcomeDto = new OutcomeDto(false, "销项已存在");
            return createOutcomeDto;
        }

        // 完善outcome信息
        String outcomeId = UUIDGeneratorUtil.getUUID();
        outcome.setId(outcomeId);

        String now = TimeUtil.now();
        outcome.setCreated_at(now);
        outcome.setUpdated_at(now);

        // 插入数据库失败
        if (!outcomeDao.createOutcome(outcome)) {
            createOutcomeDto = new OutcomeDto(false, "创建失败");
            return createOutcomeDto;
        }

        // 成功创建
        createOutcomeDto = new OutcomeDto(true, outcome);
        return createOutcomeDto;
    }

    public OutcomeDto modifyOutcomeInfo(Outcome outcome) {
        Outcome oldOutcome = outcomeDao.getOutcome(outcome.getId());
        if(oldOutcome == null) {
            return new OutcomeDto(false, "销项不存在");
        }
        oldOutcome.setTaxId(outcome.getTaxId());
        oldOutcome.setOutType(outcome.getOutType());
        oldOutcome.setMoney(outcome.getMoney());
        oldOutcome.setTaxDate(outcome.getTaxDate());
        oldOutcome.setCreated_at(outcome.getCreated_at());
        oldOutcome.setUpdated_at(outcome.getUpdated_at());

        if(!outcomeDao.updateOutcomeInfo(oldOutcome)) {
            return new OutcomeDto(false, "更新销项信息失败");
        }
        return new OutcomeDto(true, oldOutcome);    }

    public OutcomeDto createOutcomeForce(Outcome outcome, User user) {
<<<<<<< HEAD
=======

>>>>>>> 95345fa58af419a1ccd99dbfcf9ab14dd8cf6e6c
        String now = TimeUtil.now();
        outcome.setCreated_at(now);
        outcome.setUpdated_at(now);
        outcome.setUid(user.getId());
        Outcome oldOutcome = outcomeDao.getOutcomeByTaxId(outcome.getTaxId());
        if(oldOutcome != null) {
            outcome.setId(oldOutcome.getId());
            return modifyOutcomeInfo(outcome);
        } else {
            return createOutcome(outcome);
        }
    }

    public List<String> searchOutcomeList(Map<String, Object> params){ return outcomeDao.searchOutcomeList(params); }
    public List<String> typeList() {
        return outcomeDao.typeList();
    };
}
