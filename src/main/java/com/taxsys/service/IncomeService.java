package com.taxsys.service;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface IncomeService {

    List<Income> readExcelFile( MultipartFile file);

    IncomeDto createIncome(Income income);
    Income getIncome(String id);
    Income getIncomeByTaxId(String taxId);
    List getIncomes();

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
    List<String> searchIncomeList(Map<String, Object> params);
}
