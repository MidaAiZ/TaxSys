package com.taxsys.service;

import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Outcome;
import com.taxsys.model.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface OutcomeService {

    Map<String, Object> readExcelFile(MultipartFile file, User user);
    HSSFWorkbook exportExcel(HttpServletRequest request);
    OutcomeDto createOutcome(Outcome outcome);
    OutcomeDto createOutcomeForce(Outcome outcome, User user);
    Outcome getOutcome(String id);
    Outcome getOutcomeByTaxId(String taxId);
    LinkedList getOutcomes();
    boolean deleteOutcome(Outcome outcome);

    /**
     * 修改销项信息
     * @param outcome
     * @return
     */
    OutcomeDto modifyOutcomeInfo(Outcome outcome);

    /**
     * 分页获取销项
     * @param request
     * @return
     */
    List<String> searchOutcomeList(HttpServletRequest request);
    List calculate(HttpServletRequest request);
    List<String> typeList();
}
