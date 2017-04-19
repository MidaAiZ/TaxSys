package com.taxsys.dao.impl;

import com.taxsys.dao.UserDao;
import com.taxsys.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUser(String userId) {
        String hql = "from User u where u.userId=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, userId);
        return (User) query.uniqueResult();
    }
}
