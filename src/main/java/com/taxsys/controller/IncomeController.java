package com.taxsys.controller;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.User;
import com.taxsys.service.impl.IncomeServiceImpl;
import com.taxsys.service.impl.UserServiceImpl;
import com.taxsys.utils.ExportExcel;
import com.taxsys.utils.TimeUtil;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "incomes")
public class IncomeController {

    @Autowired
    private IncomeServiceImpl incomeService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadExcel(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> returnMap = new HashMap<String, Object>();

        String userId = (String)request.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        if(user == null) {
            returnMap.put("error", "用户未登录");
            return returnMap;
        }
        returnMap = incomeService.readExcelFile(file, user);
        return returnMap;
    }

    @RequestMapping(value="exportExcel", method = RequestMethod.POST)
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        HSSFWorkbook wb = incomeService.exportExcel(request);
        response.setContentType("application/x-download");
        response.setHeader("Content-disposition", "attachment;filename=incomes.xls");
        try {
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            out.println(e);
            response.setStatus(500);
        }
    }

    //新建进项表单
    @RequestMapping(value="new", method = RequestMethod.GET)
    public String newIncome() {
        return "incomes/new";
    }

    /**
     * 创建新进项
     * @param taxId 进项发票号
     * @param money 进项额
     * @param inType 进项类型
     * @param taxDate 进项日期
     * @return
     */
    @RequestMapping(value="createIncome", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createIncome(@RequestParam String taxId,
                                        @RequestParam String inType,
                                        @RequestParam Float money,
                                        @RequestParam String taxDate,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Income income = new Income(taxId, inType, money, taxDate);
        String userId = (String)request.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        if(user == null) {
            returnMap.put("error", "用户未登录");
            return returnMap;
        }

        // 设置income的uid
        income.setUid(userId);
        // 插入数据库
        IncomeDto incomeDto = incomeService.createIncome(income);
        if(incomeDto.isSuccess()){
            returnMap.put("income", incomeDto.getIncome());
        } else {
            returnMap.put("error", incomeDto.getMessage());
        }
        return returnMap;
    }

    /**
     * 强行创建新进项，覆盖旧进项
     * @param taxId 进项发票号
     * @param money 进项额
     * @param type 进项类型
     * @param taxDate 进项日期
     * @return
     */
    @RequestMapping(value="createIncomeForce", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createIncomeForce(@RequestParam String taxId,
                                            @RequestParam String type,
                                            @RequestParam Float money,
                                            @RequestParam String taxDate,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        String userId = (String)request.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        if(user == null) {
            returnMap.put("error", "用户未登录");
            return returnMap;
        }
        Income income = new Income(taxId, type, money, taxDate);
        IncomeDto incomeDto = incomeService.createIncomeForce(income, user);
        if(incomeDto.isSuccess()){
            returnMap.put("income", incomeDto.getIncome());
        } else {
            returnMap.put("error", incomeDto.getMessage());
        }
        return returnMap;
    }


    /**
     * 修改进项信息
     * @param taxId 进项发票ID
     * @param  inType 进项类型
     * @param money 进项额
     * @param created_at 进项日期
     * @return
     */
    @RequestMapping(value = "/{id}/info", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modifyIncomeInfo(@PathVariable("id") String id,
                                                @RequestParam String taxId,
                                                @RequestParam String inType,
                                                @RequestParam Float money,
                                                @RequestParam String created_at) {

        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Income income = new Income(taxId, inType, money, created_at);
        income.setId(id);
        IncomeDto incomeDto = incomeService.modifyIncomeInfo(income);
        if(incomeDto.isSuccess()){
            returnMap.put("success", incomeDto.getIncome());
        } else {
            returnMap.put("error", incomeDto.getMessage());
        }

        return returnMap;
    }

    /**
     * 得到进项信息
     * @param id 进项id
     * @return
     */
    @RequestMapping(value = "id/{taxId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> modifyIncomeInfo(@PathVariable("id") String id) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Income income = incomeService.getIncome(id);
        if(income != null){
            returnMap.put("success", income);
        } else {
            returnMap.put("error", "进项不存在");
        }
        return returnMap;
    }

    /**
     * 得到进项信息
     * @param taxId 进项id
     * @return
     */
    @RequestMapping(value = "taxId/{taxId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> modifyIncomeInfoByTaxId(@PathVariable("taxId") String taxId) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Income income = incomeService.getIncomeByTaxId(taxId);
        if(income != null){
            returnMap.put("success", income);
        } else {
            returnMap.put("error", "进项不存在");
        }
        return returnMap;
    }

    /**
     * 传入条件搜索符合标准的进项
     * @param: type, beginTime, endTime, taxId, minMoney, maxMoney
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchIncomeList(HttpServletRequest request) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try{
            List<String> incomeList = incomeService.searchIncomeList(request);
            returnMap.put("count", incomeList.get(0));
            incomeList.remove(0);
            returnMap.put("incomeList", incomeList);
        } catch (Exception e) {
            returnMap.put("error", e);
        } finally {
            return returnMap;
        }
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    @ResponseBody
    public Map getTypes() {
        Map<String, Object> returnMap = new HashMap();
        List types = incomeService.typeList();
        returnMap.put("types", types);
        return returnMap;
    }
}
