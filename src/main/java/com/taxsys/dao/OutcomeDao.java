package com.taxsys.dao;

import com.taxsys.model.Outcome;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sinner on 2017/5/24.
 */
public interface OutcomeDao {
    Outcome getOutcome(String id);

    LinkedList<Outcome> getOutcomes();

    /**
     * 创建销项
     * @param outcome
     * @return
     */
    boolean createOutcome(Outcome outcome);

    /**
     * 通过用户账户得到用户信息
     * @param taxId
     * @return
     */
    Outcome getOutcomeByTaxId(String taxId);

    /**
     * 更新销项信息
     * @param outcome
     * @return
     */
    boolean updateOutcomeInfo(Outcome outcome);
    boolean deleteOutcome(Outcome outcome);

    List searchOutcomeList(Map<String, Object> params);
    List typeList();
}
