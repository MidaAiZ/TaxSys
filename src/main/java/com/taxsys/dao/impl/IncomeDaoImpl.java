package com.taxsys.dao.impl;

import com.taxsys.dao.IncomeDao;
import com.taxsys.model.Income;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.System.out;

@Service
public class IncomeDaoImpl implements IncomeDao{
    @Autowired
    private SessionFactory sessionFactory;

    public Income getIncome(String id){
        String hql = "from income income where income.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (Income) query.uniqueResult();
    }

    public List<Income> getIncomes(){
        String hql = "FROM Income incomes order by incomes.created_at desc";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(1000);
        return query.list();
    }

    public boolean createIncome(Income income){
        Session session = sessionFactory.getCurrentSession();
        String result = (String) session.save(income);
        session.flush();
        if(result !=  ""){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 通过进项发票号得到进项信息
     * @param taxId
     * @return
     */
    public Income getIncomeByTaxId(String taxId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Income income WHERE income.taxId = ?";
        Query query = session.createQuery(hql);
        query.setString(0, taxId);
        Income income = (Income)query.uniqueResult();
        return income;
    }

    /**
     * 更新进项信息
     * @param income
     * @return
     */
    public boolean updateIncomeInfo(Income income){
        Session session = sessionFactory.getCurrentSession();
        String hql = "update Income income set income.inType = ?, income.money = ?, income.taxId = ?, income.created_at = ?where  income.id = ?";
        Query query = session.createQuery(hql);
        query.setString(0, income.getInType());
        query.setFloat(1, income.getMoney());
        query.setString(2, income.getTaxId());
        query.setString(3, income.getCreated_at());
        if(query.executeUpdate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List searchIncomeList(Map<String, Object> params){
        HashSet<String> set = new HashSet<String>();
        StringBuffer sql = new StringBuffer();

        if(params.get("type") != null) { set.add(" inType = '" + params.get("type") + "'"); }
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

        String hql = "FROM Income incomes WHERE " + sql + " order by incomes.created_at desc";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int page = Integer.parseInt((String)params.get("page"));
        int limit = Integer.parseInt((String)params.get("limit"));
        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);
        return query.list();
    }

}
