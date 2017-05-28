package com.taxsys.dao.impl;

import com.taxsys.dao.IncomeDao;
import com.taxsys.model.Income;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public LinkedList<Income> getIncomes(){
        return null;
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
     * 通过用户账户得到用户信息
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

    /**
     * 分页获取进项
     * @param offset 偏移量
     * @param limit 一次获取的数据
     * @return
     */
    public List getIncomeList(Integer offset, Integer limit){
        String hql = "from Income income order by u.created_at desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((offset - 1) * limit);
        query.setMaxResults(limit);
        return query.list();
    }
}
