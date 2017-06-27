package com.taxsys.controller;

import com.taxsys.service.impl.IncomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sinner on 2017/6/27.
 */

@Controller
@RequestMapping(value = "tax")
public class CalTaxController {
    @Autowired
    private IncomeServiceImpl incomeService;

    /**
     * 传入条件计算增值税
     * @param: 税种， 税率， 进项， 销项， 是否含税
     * 税种： 0: 普通，1: 简化，2: 预征收
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Map getTax(HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap();
//        try{
            double tax = incomeService.getTax(request);
            returnMap.put("tax", tax);
//        } catch (Exception e) {
//            returnMap.put("error", "系统错误！");
//        } finally {
            return returnMap;
//        }
    }
}
