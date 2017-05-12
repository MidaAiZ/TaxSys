package com.taxsys.service.impl;

import com.taxsys.dao.impl.UserDaoImpl;
import com.taxsys.model.User;
import com.taxsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    public User getUser(String id) {
        return userDao.getUser(id);
    }

    public LinkedList<User> getUsers() {
        return userDao.getUsers();
    }

    public User createUser(String json) {
        return userDao.createUser(json);
    }

}
