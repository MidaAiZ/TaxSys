package com.taxsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/")
public class dispatchController {
    @RequestMapping(value="", method = RequestMethod.GET)
    public String root(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "index";
    }

    @RequestMapping(value="index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "index";
    }

    @RequestMapping(value="require", method = RequestMethod.GET)
    public String require(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "require";
    }

    @RequestMapping(value="import", method = RequestMethod.GET)
    public String Import(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "import";
    }

    @RequestMapping(value="count", method = RequestMethod.GET)
    public String count(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "count";
    }

    @RequestMapping(value="chart", method = RequestMethod.GET)
    public String chart(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "chart";
    }

    @RequestMapping(value="predict", method = RequestMethod.GET)
    public String predict(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "predict";
    }

    @RequestMapping(value="calculateTax", method = RequestMethod.GET)
    public String calculateTax(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "calculateTax";
    }

    @RequestMapping(value="help", method = RequestMethod.GET)
    public String help(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "help/help";
    }

    @RequestMapping(value="help_count", method = RequestMethod.GET)
    public String helpCount(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "help/help_count";
    }

    @RequestMapping(value="help_import", method = RequestMethod.GET)
    public String helpImport(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "help/help_import";
    }

    @RequestMapping(value="help_predict", method = RequestMethod.GET)
    public String helpPredict(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "help/help_predict";
    }

    @RequestMapping(value="help_require", method = RequestMethod.GET)
    public String helpRequire(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "help/help_require";
    }

    @RequestMapping(value="center", method = RequestMethod.GET)
    public String center(HttpServletRequest request, HttpServletResponse response) {
        checkLogin(request, response);
        return "center";
    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) {
        String userId = (String)request.getSession().getAttribute("userId");
        if (userId == null) {
            try {
                response.sendRedirect("/login");
                return ;
            } catch (Exception e) {
                return;
            }
        }
    }
}


