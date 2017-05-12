package com.taxsys.controller;

import com.taxsys.model.User;
import com.taxsys.service.impl.UserServiceImpl;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value="", method = RequestMethod.GET)

    public String getUsers() {
        return null;
    }

    //新建用户
    @RequestMapping(value="", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody String request) {
        return userService.createUser(request);
    }

    //新建用户表单
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newUser() {
        return "users/new";
    }

    //获取用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    //更新用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User updateUser(@PathVariable("id") String id) {
        return null;
    }

}
