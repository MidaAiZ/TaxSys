package com.taxsys.controller;

import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.service.impl.IncomeServiceImpl;
import com.taxsys.utils.ExportExcel;
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

    @RequestMapping(value="upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam(value="file",required = false)MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> returnMap = new HashMap<String, Object>();

        List<Income> incomeList = incomeService.readExcelFile(file);
        if (incomeList != null) {
            Iterator it = incomeList.iterator();
            int index = 0;
            HashSet hs = new HashSet();
            while (it.hasNext()) {
                index ++;
                hs.add(it.next());
            }
            returnMap.put("incomes", hs.toArray());
        } else {
            returnMap.put("error", "导入失败！");
        }
        return returnMap;
    }

    @RequestMapping(value="exportExcel", method = RequestMethod.POST)
    @ResponseBody
    public void exportLabType(HttpServletRequest request, HttpServletResponse response){
        //以下是从前台获取参数
        String typeId = request.getParameter("taxId");
        String typeName = request.getParameter("inType");
        String money = request.getParameter("money");
        String created_at = request.getParameter("created_at");
        //存成数组格式
        //需要导出的excel表头
        String[] zd = { typeId, typeName, money, created_at };
//        String[] zd = col; //需要导出的字段
        String[] col = { "发票号", "类型", "金额", "日期" };
        //下面用到上面的类，需要传递实体参数
        ExportExcel<Income> ee = new ExportExcel<Income>();
        //最后一个参数是数据集合
        List list  = incomeService.getIncomes();
        HSSFWorkbook wb = ee.exportExcel("进项", col, zd, list);
//        response.setContentType("application/vnd.ms-excel");
        response.setContentType("application/x-download");
        response.setHeader("Content-disposition", "attachment;filename=student.xls");
        try {
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
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

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    @ResponseBody
    public Map getTypes() {
        Map<String, Object> returnMap = new HashMap();
//        String[] types = {"牛肉", "猪肉", "羊肉", "玻璃", "铁皮", "香蕉", "鱼肉", "纯净水", "花生油"};
        List types = incomeService.typeList();
        returnMap.put("types", types);
        return returnMap;
    }
}
