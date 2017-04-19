package com.taxsys.controller;

import com.taxsys.model.User;
import com.taxsys.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by 刘华鑫 on 2017/4/19.
 */
@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserList(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }
}
