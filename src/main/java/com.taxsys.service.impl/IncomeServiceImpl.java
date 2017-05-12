package com.taxsys.service.impl;

import com.taxsys.dao.impl.IncomeDaoImpl;
import com.taxsys.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sinner on 2017/5/12.
 */

@Service
public class IncomeServiceImpl {
    @Autowired
    IncomeDaoImpl incomeDao;

    public Income getIncome(String id) { return incomeDao.getIncome(id); }
}
