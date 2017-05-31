package com.taxsys.service;

import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Outcome;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface OutcomeService {

    OutcomeDto createOutcome(Outcome outcome);
    Outcome getOutcome(String id);
    Outcome getOutcomeByTaxId(String taxId);
    LinkedList getOutcomes();

    /**
     * 修改销项信息
     * @param outcome
     * @return
     */
    OutcomeDto modifyOutcomeInfo(Outcome outcome);

    /**
     * 分页获取销项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    List<String> searchOutcomeList(Map<String, Object> params);
}
