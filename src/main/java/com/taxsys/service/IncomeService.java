package com.taxsys.service;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.User;
<<<<<<< HEAD
=======
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
>>>>>>> 95345fa58af419a1ccd99dbfcf9ab14dd8cf6e6c
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IncomeService {

    Map<String, Object> readExcelFile( MultipartFile file, User user);
<<<<<<< HEAD

=======
    HSSFWorkbook exportExcel(HttpServletRequest request);
>>>>>>> 95345fa58af419a1ccd99dbfcf9ab14dd8cf6e6c
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
