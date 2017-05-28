package com.taxsys.dao.impl;

import com.taxsys.dao.OutcomeDao;
import com.taxsys.model.Outcome;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

@Service
public class OutcomeDaoImpl implements OutcomeDao{
    @Autowired
    private SessionFactory sessionFactory;

    public Outcome getOutcome(String id){
        String hql = "from outcome outcome where outcome.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (Outcome) query.uniqueResult();
    }

    public LinkedList<Outcome> getOutcomes(){
        return null;
    }

    public boolean createOutcome(Outcome outcome){
        Session session = sessionFactory.getCurrentSession();
        String result = (String) session.save(outcome);
        session.flush();
        if(result !=  ""){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 通过用户账户得到用户信息
     * @param taxId
     * @return
     */
    public Outcome getOutcomeByTaxId(String taxId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Outcome outcome WHERE outcome.taxId = ?";
        Query query = session.createQuery(hql);
        query.setString(0, taxId);
        Outcome outcome = (Outcome)query.uniqueResult();
        return outcome;
    }

    /**
     * 更新销项信息
     * @param outcome
     * @return
     */
    public boolean updateOutcomeInfo(Outcome outcome){
        Session session = sessionFactory.getCurrentSession();
        String hql = "update Outcome outcome set outcome.outType = ?, outcome.money = ?, outcome.taxId = ?, outcome.created_at = ?where  outcome.id = ?";
        Query query = session.createQuery(hql);
        query.setString(0, outcome.getOutType());
        query.setFloat(1, outcome.getMoney());
        query.setString(2, outcome.getTaxId());
        query.setString(3, outcome.getCreated_at());
        if(query.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 分页获取销项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    public List getOutcomeList(Integer offset, Integer limit){
        String hql = "from Outcome outcome order by u.created_at desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((offset - 1) * limit);
        query.setMaxResults(limit);
        return query.list();
    }
}
