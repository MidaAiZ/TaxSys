package com.taxsys.controller;

import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Outcome;
import com.taxsys.service.impl.OutcomeServiceImpl;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping(value = "outcomes")
public class OutcomeController {

    @Autowired
    private OutcomeServiceImpl outcomeService;

    @RequestMapping(value="upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> returnMap = new HashMap<String, Object>();

        List<Outcome> outcomeList = outcomeService.readExcelFile(file);
        if (outcomeList != null) {
            Iterator it = outcomeList.iterator();
            int index = 0;
            HashSet hs = new HashSet();
            while (it.hasNext()) {
                index ++;
                hs.add(it.next());
            }
            returnMap.put("outcomes", hs.toArray());
        } else {
            returnMap.put("error", "导入失败！");
        }
        return returnMap;
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
     * @param created_at 销项日期
     * @return
     */
    @RequestMapping(value="createOutcome", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createOutcome(@RequestParam String taxId,
                                             @RequestParam String outType,
                                             @RequestParam Float money,
                                             @RequestParam String created_at,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {
        // response返回的json内容
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Outcome outcome = new Outcome(taxId, outType, money, created_at);
        String outcomeId = UUIDGeneratorUtil.getUUID();
        outcome.setId(outcomeId);

        OutcomeDto outcomeDto = outcomeService.createOutcome(outcome);
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
     * 传入条件搜索符合标准的进项
     * @param: type, beginTime, endTime, taxId, minMoney, maxMoney
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchOutcomeList(@RequestParam(required=false) String type,
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

        List<String> outcomeList = outcomeService.searchOutcomeList(paramsMap);
        returnMap.put("outcomeList", outcomeList);
        return returnMap;
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
