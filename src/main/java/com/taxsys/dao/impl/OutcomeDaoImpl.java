package com.taxsys.dao.impl;

import com.taxsys.dao.OutcomeDao;
import com.taxsys.model.Outcome;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
     * 通过销项发票号得到销项信息
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

    public List searchOutcomeList(Map<String, Object> params){
        HashSet<String> set = new HashSet<String>();
        StringBuffer sql = new StringBuffer();

        if(params.get("type") != null) { set.add(" type = '" + params.get("type") + "'"); }
        if(params.get("taxId") != null) { set.add(" taxId = '" + params.get("taxId") + "'"); }
        if(params.get("minMoney") != null) { set.add(" money >= " + params.get("minMoney")); }
        if(params.get("maxMoney") != null) { set.add(" money <= " + params.get("maxMoney")); }
        if(params.get("beginTime") != null) { set.add(" created_at >= '" + params.get("beginTime") +"'"); }
        if(params.get("endTime") != null) { set.add(" created_at <= '" + params.get("endTime") + "'"); }

        Iterator<String> it = set.iterator();
        if (it.hasNext()) { sql.append(it.next()); }
        while(it.hasNext()) {
            sql.append(" AND " + it.next());
        }

        String hql = "FROM Outcome outcomes WHERE " + sql + " order by outcomes.created_at desc";
        out.println("输出结果：" + hql);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int page = Integer.parseInt((String)params.get("page"));
        int limit = Integer.parseInt((String)params.get("limit"));
        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);
        return query.list();
    }

}
