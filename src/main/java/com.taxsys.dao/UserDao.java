package com.taxsys.dao;

import com.taxsys.model.User;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
public interface UserDao {

    User getUser(String userId);
}
