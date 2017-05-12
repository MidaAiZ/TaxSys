package com.taxsys.controller;

import com.taxsys.service.impl.IncomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sinner on 2017/5/12.
 */

@Controller
@RequestMapping(value = "inputs")
public class IncomeController {
    @Autowired
    IncomeServiceImpl inputService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getIncome(@RequestBody String request) {
        return "";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String setIncome(@RequestBody String request) {
        return "";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateIncome(@RequestBody String request) {
        return "";
    }

}
