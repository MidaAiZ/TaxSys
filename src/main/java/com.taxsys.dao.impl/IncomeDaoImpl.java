package com.taxsys.dao.impl;

import com.taxsys.dao.IncomeDao;
import com.taxsys.model.Income;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sinner on 2017/5/12.
 */
public class IncomeDaoImpl implements IncomeDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Income getIncome(String id) {
        String hql = "from Income i where i.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (Income) query.uniqueResult();
    }

}
