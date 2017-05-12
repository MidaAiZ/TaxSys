package com.taxsys.dao.impl;

import com.taxsys.dao.UserDao;
import com.taxsys.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

//    public User setUser(HttpServletRequst request) {
//        String hql = "insert User u where u.id=?";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setString(0, id);
//        return (User) query.uniqueResult();
//    }

    public User getUser(String id) {
        String hql = "from User u where u.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        return (User) query.uniqueResult();
    }

    public LinkedList<User> getUsers() {
        return null;
    }

    public User createUser(String json) {
        return  null;
    }
}
