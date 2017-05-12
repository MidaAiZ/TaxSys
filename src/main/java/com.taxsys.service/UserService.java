package com.taxsys.service;

import com.taxsys.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;

/**
 * Created by 刘华鑫 on 2017/4/19.
 */
public interface UserService {

    User getUser(String id);
    LinkedList getUsers();
    User createUser(@RequestBody String request);

}
