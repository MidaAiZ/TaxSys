package com.taxsys.service;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import java.util.LinkedList;
import java.util.List;

public interface IncomeService {

    IncomeDto createIncome(Income income);
    Income getIncome(String id);
    Income getIncomeByTaxId(String taxId);
    LinkedList getIncomes();

   /**
     * 修改进项信息
     * @param income
     * @return
     */
    IncomeDto modifyIncomeInfo(Income income);

    /**
     * 分页获取进项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    List<String> getIncomeList(Integer offset, Integer limit);
}