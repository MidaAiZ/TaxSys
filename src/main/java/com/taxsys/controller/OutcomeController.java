package com.taxsys.controller;

import com.taxsys.dto.IncomeDto;
import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Outcome;
import com.taxsys.model.User;
import com.taxsys.service.impl.OutcomeServiceImpl;
import com.taxsys.service.impl.UserServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "outcomes")
public class OutcomeController {

    @Autowired
    private OutcomeServiceImpl outcomeService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> returnMap = new HashMap<String, Object>();

        String userId = (String)request.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        if(user == null) {
            returnMap.put("error", "用户未登录");
            return returnMap;
        }
        returnMap = outcomeService.readExcelFile(file, user);
        return returnMap;
    }

    @RequestMapping(value="exportExcel", method = RequestMethod.POST)
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        HSSFWorkbook wb = outcomeService.exportExcel(request);
        response.setContentType("application/x-download");
        response.setHeader("Content-disposition", "attachment;filename=outcomes.xls");
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



    //新建销项表单
    @RequestMapping(value="new", method = RequestMethod.GET)
    public String newOutcome() {
        return "outcomes/new";
    }

    /**
     * 创建新销项
     * @param taxId 销项发票号
     * @param money 销项额
     * @param outType 销项类型
     * @param taxDate 销项日期
     * @return
     */
    @RequestMapping(value="createOutcome", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createOutcome(@RequestParam String taxId,
                                             @RequestParam String outType,
                                             @RequestParam Float money,
                                             @RequestParam String taxDate,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Outcome outcome = new Outcome(taxId, outType, money, taxDate);

        String userId = (String)request.getSession().getAttribute("userId");
        User user = userService.getUser(userId);
        if(user == null) {
            returnMap.put("error", "UserUnLoggedIn");
            return returnMap;
        }

        // 设置outcome的uid
        outcome.setUid(userId);


        OutcomeDto outcomeDto = outcomeService.createOutcome(outcome);
        if(outcomeDto.isSuccess()){
            returnMap.put("outcome", outcomeDto.getOutcome());
        } else {
            returnMap.put("error", outcomeDto.getMessage());
        }
        return returnMap;
    }

    /**
     * 强行创建新销项， 覆盖旧销项
     * @param taxId 销项发票号
     * @param money 销项额
     * @param type 销项类型
     * @param taxDate 销项日期
     * @return
     */
    @RequestMapping(value="createOutcomeForce", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createOutcomeForce(@RequestParam String taxId,
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
        Outcome outcome = new Outcome(taxId, type, money, taxDate);
        OutcomeDto outcomeDto = outcomeService.createOutcomeForce(outcome, user);
        if(outcomeDto.isSuccess()){
            returnMap.put("outcome", outcomeDto.getOutcome());
        } else {
            returnMap.put("error", outcomeDto.getMessage());
        }
        return returnMap;
    }

    /**
     * 修改销项信息
     * @param taxId 销项发票ID
     * @param  outType 销项类型
     * @param money 销项额
     * @param created_at 销项日期
     * @return
     */
    @RequestMapping(value = "/{id}/info", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modifyOutcomeInfo(@PathVariable("id") String id,
                                                 @RequestParam String taxId,
                                                 @RequestParam String outType,
                                                 @RequestParam Float money,
                                                 @RequestParam String created_at) {

        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Outcome outcome = new Outcome(taxId, outType, money, created_at);
        outcome.setId(id);
        OutcomeDto outcomeDto = outcomeService.modifyOutcomeInfo(outcome);
        if(outcomeDto.isSuccess()){
            returnMap.put("success", outcomeDto.getOutcome());
        } else {
            returnMap.put("error", outcomeDto.getMessage());
        }

        return returnMap;
    }

    /**
     * 得到销项信息
     * @param id 销项id
     * @return
     */
    @RequestMapping(value = "id/{taxId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> modifyOutcomeInfo(@PathVariable("id") String id) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Outcome outcome = outcomeService.getOutcome(id);
        if(outcome != null){
            returnMap.put("success", outcome);
        } else {
            returnMap.put("error", "销项不存在");
        }
        return returnMap;
    }

    /**
     * 得到销项信息
     * @param taxId 销项id
     * @return
     */
    @RequestMapping(value = "taxId/{taxId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> modifyOutcomeInfoByTaxId(@PathVariable("taxId") String taxId) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Outcome outcome = outcomeService.getOutcomeByTaxId(taxId);
        if(outcome != null){
            returnMap.put("success", outcome);
        } else {
            returnMap.put("error", "销项不存在");
        }
        return returnMap;
    }

    /**
     * 传入条件搜索符合标准的销项
     * @param: type, beginTime, endTime, taxId, minMoney, maxMoney
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchOutcomeList(HttpServletRequest request) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        try {
            request.setCharacterEncoding("UTF-8");
            List<String> outcomeList = outcomeService.searchOutcomeList(request);
            returnMap.put("count", outcomeList.get(0));
            outcomeList.remove(0);
            returnMap.put("outcomeList", outcomeList);
        }catch(Exception e) {
            returnMap.put("error", e);
        } finally {
            return returnMap;
        }
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    @ResponseBody
    public Map getTypes() {
        Map<String, Object> returnMap = new HashMap();
        List types = outcomeService.typeList();
        returnMap.put("types", types);
        return returnMap;
    }
}
