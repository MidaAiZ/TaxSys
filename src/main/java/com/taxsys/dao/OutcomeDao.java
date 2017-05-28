package com.taxsys.dao;

import com.taxsys.model.Outcome;
import com.taxsys.model.User;

import java.util.LinkedList;
import java.util.List;

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

    /**
     * 分页获取销项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    List getOutcomeList(Integer offset, Integer limit);
}
