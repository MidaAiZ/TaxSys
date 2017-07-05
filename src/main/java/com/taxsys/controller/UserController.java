package com.taxsys.controller;

import com.taxsys.dto.UserDto;
import com.taxsys.model.User;
import com.taxsys.service.impl.UserServiceImpl;
import com.taxsys.utils.MD5Util;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;


@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //新建用户表单
    @RequestMapping(value="new", method = RequestMethod.GET)
    public String newUser() {
        return "users/new";
    }

    /**
     * 用户注册
     * 注册后将在Cookies中放置sessionId，token
     * @param cellphone 手机号
     * @param number 用户账号
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value="register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestParam String cellphone,
                                          @RequestParam String number,
                                          @RequestParam String password,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        User user = new User(number, cellphone, password);

        UserDto userDto = userService.register(user);
        if(userDto.isSuccess()){
            // 得到sessionId
            String sessionId = request.getSession().getId();
            // 将sessionId 保存至cookie
            Cookie cookie = new Cookie("sessionId", sessionId);
            // 设置cookie超时为一天
            cookie.setMaxAge(24 * 60 * 60);

            response.addCookie(cookie);
            // 将密码去除
            userDto.getUser().setPassword("");
            returnMap.put("user", userDto.getUser());
        } else {
            returnMap.put("error", userDto.getMessage());
        }
        return returnMap;
    }

    /**
     * 用户登录
     * 登录后将在Cookies中放置sessionId，token
     * @param number 用户账号
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam String number,
                                     @RequestParam String password,
                                     HttpServletRequest request,
                                     HttpServletResponse response){
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        UserDto userDto = userService.login(number, password);
        if(userDto.isSuccess()){
            // 得到sessionId
            String sessionId = request.getSession().getId();
            // 将sessionId 保存至cookie
            Cookie cookie = new Cookie("sessionId", sessionId);
            // 设置cookie超时为一天
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            // 将UserId 保存至session
            request.getSession().setAttribute("userId", userDto.getUser().getId());

            // 将密码去除
            userDto.getUser().setPassword("");
            returnMap.put("user", userDto.getUser());
        } else {
            returnMap.put("error", userDto.getMessage());
        }
        return returnMap;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> logout( HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> returnMap = new HashMap<String, Object>();

        String sessionId = request.getSession().getId();
        request.getSession().removeAttribute(sessionId);
        request.getSession().removeAttribute("userId");
        Cookie cookie = new Cookie("sessionId", null);
        response.addCookie(cookie);
        returnMap.put("logout",true);
        return returnMap;
    }

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPassword 用户原密码
     * @param newPassword 用户新密码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/{id}/password", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modifyPassword(@PathVariable("id") String id,
                                              @RequestParam String oldPassword,
                                              @RequestParam String newPassword,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        UserDto userDto = userService.modifyPassword(id, oldPassword, newPassword);
        if(userDto.isSuccess()){
            // 将原来的session失效
            request.getSession().invalidate();
            // 得到新的sessionId
            String sessionId = request.getSession().getId();
            // 将新的sessionId 保存至cookie
            Cookie cookie = new Cookie("sessionId", sessionId);
            // 设置cookie超时为一天
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            // 将密码去除
            userDto.getUser().setPassword("");
            returnMap.put("user", userDto.getUser());
        } else {
            returnMap.put("error", userDto.getMessage());
        }
        return returnMap;
    }

    /**
     * 修改用户信息
     * @param id 用户id
     * @param gender 用户性别
     * @param avatar 用户头像
     * @return
     */
    @RequestMapping(value = "/{id}/info", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modifyUserInfo(@PathVariable("id") String id,
                                              @RequestParam(required=false) Integer gender,
                                              @RequestParam(required=false) String nickname,
                                              @RequestParam(required=false) String avatar) {

        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        User user = new User(gender, avatar);
        user.setId(id);
        UserDto userDto = userService.modifyUserInfo(user);
        if(userDto.isSuccess()){
            userDto.getUser().setPassword("");
            returnMap.put("success", userDto.getUser());
        } else {
            returnMap.put("error", userDto.getMessage());
        }

        return returnMap;
    }

    /**
     * 得到用户信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> modifyUserInfo(@PathVariable("id") String id) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        User user = userService.getUser(id);
        if(user != null){
            user.setPassword("");
            returnMap.put("success", user);
        } else {
            returnMap.put("error", "用户不存在");
        }
        return returnMap;
    }

    /**
     * 得到用户个人详细信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/self", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserPersonalInfo( HttpServletRequest request) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String id = (String)request.getSession().getAttribute("userId");
        if(id == null){
            returnMap.put("error", "非法访问,上帝正在注视你.");
        }

        User user = userService.getUser(id);
        if(user != null){
            returnMap.put("number", user.getNumber());
            returnMap.put("phone", user.getCellphone());
            returnMap.put("role", user.getRole());
            returnMap.put("created_at", user.getCreated_at());
        } else {
            returnMap.put("error", "非法访问,上帝正在注视你.");
        }
        return returnMap;
    }

    /**
     * 获取用户列表
     * @param limit
     * @return
     */
    @RequestMapping(value = "/list/{offset}/{limit}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList(@PathVariable("offset") Integer offset,
                                           @PathVariable("limit") Integer limit) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        List<String> userIdList = userService.getUserList(offset, limit);
        returnMap.put("userIdList", userIdList);
        return returnMap;
    }
}
