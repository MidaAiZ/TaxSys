package com.taxsys.service.impl;

import com.taxsys.dao.impl.UserDaoImpl;
import com.taxsys.model.User;
import com.taxsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDaoImpl userDao;

    public User getUser(String userId) {
        return userDao.getUser(userId);
    }
}
