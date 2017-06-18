package com.taxsys.service.impl;

import com.taxsys.dao.impl.OutcomeDaoImpl;
import com.taxsys.dto.OutcomeDto;
import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Outcome;
import com.taxsys.model.Outcome;
import com.taxsys.service.OutcomeService;
import com.taxsys.utils.MD5Util;
import com.taxsys.utils.ReadExcel;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Service
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    OutcomeDaoImpl outcomeDao;

    public List<Outcome> readExcelFile(MultipartFile file) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<Outcome> outcomeList = readExcel.getExcelInfo(file, "outcome");
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        if(outcomeList != null){
            try{
                for(Outcome i : outcomeList) {
                    String outcomeId = UUIDGeneratorUtil.getUUID();
                    i.setId(outcomeId);
                    outcomeDao.createOutcome(i);
                };
                return outcomeList;
            } catch (Exception e) {
            }
            return null;
        }else{
            return null;
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

        // 检查用户账户查重
        if (outcomeDao.getOutcomeByTaxId(outcome.getTaxId()) != null) {
            createOutcomeDto = new OutcomeDto(false, "销项已存在");
            return createOutcomeDto;
        }

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
        if(oldOutcome.getTaxId() != outcome.getTaxId()) {
            oldOutcome.setTaxId(outcome.getTaxId());
        }
        if(oldOutcome.getOutType() != outcome.getOutType()) {
            oldOutcome.setOutType(outcome.getOutType());
        }
        if(oldOutcome.getMoney() != 0 && oldOutcome.getMoney() != (outcome.getMoney())) {
            oldOutcome.setMoney(outcome.getMoney());
        }
        if(oldOutcome.getCreated_at() != null && !oldOutcome.getCreated_at().equals(outcome.getCreated_at())) {
            oldOutcome.setCreated_at(outcome.getCreated_at());
        }
        if(!outcomeDao.updateOutcomeInfo(oldOutcome)) {
            return new OutcomeDto(false, "更新销项信息失败");
        }
        return new OutcomeDto(true, oldOutcome);    }

    public List<String> searchOutcomeList(Map<String, Object> params){ return outcomeDao.searchOutcomeList(params); }
    public List<String> typeList() {
        return outcomeDao.typeList();
    };
}
