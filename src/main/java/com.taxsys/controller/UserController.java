package com.taxsys.controller;

import com.taxsys.model.User;
import com.taxsys.service.impl.SqlInjectServiceImpl;
import com.taxsys.service.impl.UserServiceImpl;
import com.taxsys.utils.Json2ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;


@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SqlInjectServiceImpl sqlInjectService;


    @RequestMapping(value="", method = RequestMethod.GET)
    public String getUsers() {
        return "users/new";
    }

    //新建用户
    @RequestMapping(value="", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createUser(@RequestBody String request) {

        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        // 防注入
//        String json = sqlInjectService.SqlInjectHandle(request);
        User user = Json2ObjectUtil.getUser(request);

        out.println("输出用户信息\n  账号：  " + user.getNumber() + ",  ID： " + user.getId() + ",  手机号： " + user.getCellphone());

        // 新用户合法
        if (user.getId() != null) {
            returnMap.put("user", userService.createUser(user));
        } else {
            returnMap.put("errors", "注册失败， 字段不合法");
        }

       return returnMap;
    }

    //新建用户表单
    @RequestMapping(value="new", method = RequestMethod.GET)
    public String newUser() {
        return "users/new";
    }

    //获取用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") String id) {
        return "users/new";
    }

    //更新用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") String id) {
        return "users/new";
    }
}
