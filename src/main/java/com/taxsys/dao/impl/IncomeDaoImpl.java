package com.taxsys.dao.impl;

import com.taxsys.dao.IncomeDao;
import com.taxsys.model.Income;
import com.taxsys.utils.TimeUtil;
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
        String hql = "from Income income where income.id=?";
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
        String hql = "update Income income set income.inType = ?, income.money = ?, income.taxId = ?, income.taxDate = ?, income.created_at = ?, income.updated_at = ? where  income.id = ?";
        Query query = session.createQuery(hql);
        query.setString(0, income.getInType());
        query.setFloat(1, income.getMoney());
        query.setString(2, income.getTaxId());
        query.setString(3, income.getTaxDate());
        query.setString(4, TimeUtil.now());
        query.setString(5, TimeUtil.now());
        query.setString(6, income.getId());

        out.println("我要跟新啦！");
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
        if(params.get("beginTime") != null) { set.add(" taxDate >= '" + params.get("beginTime") +"'"); }
        if(params.get("endTime") != null) { set.add(" taxDate <= '" + params.get("endTime") + "'"); }
        if(params.get("userId") != null) { set.add(" uid = '" + params.get("userId") + "'"); }

        Iterator<String> it = set.iterator();
        if (it.hasNext()) { sql.append(" WHERE ").append(it.next()); }
        while(it.hasNext()) {
            sql.append(" AND " + it.next());
        }

        String hqlCount = "select COUNT(1) FROM Income incomes " + sql + " order by incomes.created_at desc";
        String hql =  "FROM Income incomes " + sql + " order by incomes.created_at desc";

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
        String hql = "select distinct inType from Income income order by income.created_at desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setFirstResult((offset - 1) * limit);
//        query.setMaxResults(limit);
        return query.list();
    }

}
