package com.taxsys.dao;

import com.taxsys.model.Income;
import com.taxsys.model.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sinner on 2017/5/24.
 */
public interface IncomeDao {
    Income getIncome(String id);

    LinkedList<Income> getIncomes();

    /**
     * 创建进项
     * @param income
     * @return
     */
    boolean createIncome(Income income);

    /**
     * 通过用户账户得到用户信息
     * @param taxId
     * @return
     */
    Income getIncomeByTaxId(String taxId);

    /**
     * 更新进项信息
     * @param income
     * @return
     */
    boolean updateIncomeInfo(Income income);

    /**
     * 分页获取进项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    List getIncomeList(Integer offset, Integer limit);
}
