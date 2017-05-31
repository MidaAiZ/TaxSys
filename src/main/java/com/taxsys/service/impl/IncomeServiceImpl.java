package com.taxsys.service.impl;

import com.taxsys.dao.impl.IncomeDaoImpl;
import com.taxsys.dto.IncomeDto;
import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Income;
import com.taxsys.service.IncomeService;
import com.taxsys.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeDaoImpl incomeDao;

    public Income getIncome(String id) {
        return incomeDao.getIncome(id);
    }

    public Income getIncomeByTaxId(String taxId) {
        return incomeDao.getIncomeByTaxId(taxId);
    }

    public LinkedList<Income> getIncomes() {
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
    }
