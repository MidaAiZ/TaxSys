package com.taxsys.dao.impl;

import com.taxsys.dao.OutcomeDao;
import com.taxsys.model.Outcome;
import com.taxsys.utils.TimeUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutcomeDaoImpl implements OutcomeDao{
    @Autowired
    private SessionFactory sessionFactory;

    public Outcome getOutcome(String id){
        String hql = "from Outcome outcome where outcome.id=?";
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
        String hql = "update Outcome outcome set outcome.outType = ?, outcome.money = ?, outcome.taxId = ?, outcome.taxDate = ?, outcome.updated_at = ? where  outcome.id = ?";
        Query query = session.createQuery(hql);
        query.setString(0, outcome.getOutType());
        query.setFloat(1, outcome.getMoney());
        query.setString(2, outcome.getTaxId());
        query.setString(3, outcome.getTaxDate());
        query.setString(4, TimeUtil.now());
        query.setString(5, outcome.getId());

        if(query.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteOutcome(Outcome outcome) {
        String hql = "delete Outcome outcome where outcome.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, outcome.getId());
        return (query.executeUpdate() > 0);
    }


    public List searchOutcomeList(Map<String, Object> params){
        HashSet<String> set = new HashSet<String>();
        StringBuffer sql = new StringBuffer();

        if(params.get("type") != null) { set.add(" type = '" + params.get("type") + "'"); }
        if(params.get("taxId") != null) { set.add(" taxId = '" + params.get("taxId") + "'"); }
        if(params.get("minMoney") != null) { set.add(" money >= " + params.get("minMoney")); }
        if(params.get("maxMoney") != null) { set.add(" money <= " + params.get("maxMoney")); }
        if(params.get("beginTime") != null) { set.add(" taxDate >= '" + params.get("beginTime") +"'"); }
        if(params.get("endTime") != null) { set.add(" taxDate <= '" + params.get("endTime") + "'"); }
        if(params.get("createdBegin") != null) { set.add(" created_at >= '" + params.get("createdBegin") + "'"); }
        if(params.get("createdEnd") != null) { set.add(" created_at <= '" + params.get("createdEnd") + "'"); }
        if(params.get("userId") != null) { set.add(" uid = '" + params.get("userId") + "'"); }
        String order = "created_at";
        if(params.get("orderBy") != null) { order = (String)params.get("orderBy"); }

        Iterator<String> it = set.iterator();
        if (it.hasNext()) { sql.append(" WHERE ").append(it.next()); }
        while(it.hasNext()) {
            sql.append(" AND " + it.next());
        }

        String hqlCount = "select COUNT(1) FROM Outcome outcomes " + sql + " order by outcomes." + order + " desc";
        String hql = "FROM Outcome outcomes " + sql + " order by outcomes.created_at desc";

        Query countQuery = sessionFactory.getCurrentSession().createQuery(hqlCount);
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        int page = Integer.parseInt((String)params.get("page"));
        int limit = Integer.parseInt((String)params.get("limit"));
        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);

        List list= query.list();
        int count= ((Number)countQuery.list().iterator().next()).intValue();
        // 注意这里的类型转化
        list.add(0, count);
        return list;
    }
    public List typeList() {
        String hql = "select distinct outType from Outcome outcome order by outcome.created_at desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setFirstResult((offset - 1) * limit);
//        query.setMaxResults(limit);
        return query.list();
    }

}
