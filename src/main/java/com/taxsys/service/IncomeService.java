package com.taxsys.service;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IncomeService {

    Map<String, Object> readExcelFile( MultipartFile file, User user);
    HSSFWorkbook exportExcel(HttpServletRequest request);
    IncomeDto createIncome(Income income);
    IncomeDto createIncomeForce(Income income, User user);
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
     * 分页多条件获取进项
     * @return
     */
    List<String> searchIncomeList(HttpServletRequest request);

    List<String> typeList();
}
