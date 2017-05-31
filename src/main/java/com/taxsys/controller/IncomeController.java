package com.taxsys.controller;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.service.impl.IncomeServiceImpl;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Controller
@RequestMapping(value = "incomes")
public class IncomeController {

    @Autowired
    private IncomeServiceImpl incomeService;

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
     * @param created_at 进项日期
     * @return
     */
    @RequestMapping(value="createIncome", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createIncome(@RequestParam String taxId,
                                        @RequestParam String inType,
                                        @RequestParam Float money,
                                        @RequestParam String created_at,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Income income = new Income(taxId, inType, money, created_at);
        String incomeId = UUIDGeneratorUtil.getUUID();
        income.setId(incomeId);

        IncomeDto incomeDto = incomeService.createIncome(income);
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
    public Map<String, Object> searchIncomeList(@RequestParam(required=false) String type,
                                                @RequestParam(required=false) String beginTime,
                                                @RequestParam(required=false) String endTime,
                                                @RequestParam(required=false) String taxId,
                                                @RequestParam(required=false) String minMoney,
                                                @RequestParam(required=false) String maxMoney,
                                                @RequestParam(required=false) String page,
                                                @RequestParam(required=false) String limit
                                                ) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        if (page == null) { page = "1"; }
        if (limit == null) { limit = "100"; }
        paramsMap.put("type", type);
        paramsMap.put("beginTime", beginTime);
        paramsMap.put("endTime", endTime);
        paramsMap.put("taxId", taxId);
        paramsMap.put("minMoney", minMoney);
        paramsMap.put("maxMoney", maxMoney);
        paramsMap.put("page", page);
        paramsMap.put("limit", limit);

        List<String> incomeList = incomeService.searchIncomeList(paramsMap);
        returnMap.put("incomeList", incomeList);
        return returnMap;
    }
}
