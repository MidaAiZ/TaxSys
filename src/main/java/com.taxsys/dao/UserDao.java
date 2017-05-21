package com.taxsys.dao;

import com.taxsys.model.User;

import java.util.LinkedList;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
public interface UserDao {

    User getUser(String id);
    LinkedList<User> getUsers();
    User createUser(User user);
}
