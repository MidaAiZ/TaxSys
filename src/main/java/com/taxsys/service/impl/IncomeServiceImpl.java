package com.taxsys.service.impl;

import com.taxcal.Analysis.PlainDataAnalysis;
import com.taxcal.Analysis.SeasonData;
import com.taxcal.Analysis.SeasonDataAnalysis;
import com.taxcal.Method.TaxCalculator;
import com.taxcal.Method.VATType;
import com.taxsys.dao.impl.IncomeDaoImpl;
import com.taxsys.dto.IncomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Outcome;
import com.taxsys.model.User;
import com.taxsys.service.IncomeService;
import com.taxsys.utils.ExportExcel;
import com.taxsys.utils.ReadExcel;
import com.taxsys.utils.TimeUtil;
import com.taxsys.utils.UUIDGeneratorUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeDaoImpl incomeDao;

    @Autowired
    private OutcomeServiceImpl outcomeService;


    public HSSFWorkbook exportExcel(HttpServletRequest request) {
        //以下是从前台获取参数
        int len = 0;
        if(request.getParameter("getTaxId") != null) { len ++; }
        if(request.getParameter("getType") != null) { len ++; }
        if(request.getParameter("getMoney") != null) { len ++; }
        if(request.getParameter("getTaxDate") != null) { len ++; }

        String[] zd = new String[len], col = new String[len];
        int i = 0;
        if(request.getParameter("getTaxId") != null) { zd[i] = "taxId"; col[i] = "进项发票"; i ++; }
        if(request.getParameter("getType") != null) { zd[i] = "inType"; col[i] = "进项类型"; i ++; }
        if(request.getParameter("getMoney") != null) { zd[i] = "money"; col[i] = "金额"; i ++; }
        if(request.getParameter("getTaxDate") != null) { zd[i] = "taxDate"; col[i] = "日期"; }
        try{
            // 获取数据
            List list = searchIncomeList(request);
            list.remove(0); //总条数信息
            //下面用到上面的类，需要传递实体参数
            ExportExcel<Income> ee = new ExportExcel<Income>();
            //最后一个参数是数据集合
            HSSFWorkbook wb = ee.exportExcel("进项", col, zd, list);
            return wb;
        } catch (Exception e) {
            out.println(e);
            return null;
        }
    }

    public Map<String, Object> readExcelFile(MultipartFile file, User user) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        Map<String, Object> resultMap = new HashMap();

        try {
            List<Income> incomeList = readExcel.getExcelInfo(file, "income");
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,

            if (incomeList.size() == 1 && incomeList.get(0).equals("ERROR FILE")) {
                resultMap.put("error", "文件格式错误！");
            } else if (incomeList != null) {
                List successList = new LinkedList(); // 添加成功的进项
                List failList = new LinkedList(); // 添加失败的进项

                try {
                    for (Income i : incomeList) {
                        i.setUid(user.getId());
                        try {
                            IncomeDto incomeDto = createIncome(i);
                            if (incomeDto.isSuccess()) {
                                successList.add(incomeDto.getIncome());
                            } else {
                                Map failMap = new HashMap<String, Object>();
                                failMap.put("error", incomeDto.getMessage());
                                failMap.put("income", i);
                                failList.add(failMap);
                            }
                        } catch (Exception e) {
                            Map failMap = new HashMap<String, Object>();
                            out.println(e);
                            failMap.put("error", "数据错误！");
                            failMap.put("income", i);
                            failList.add(failMap);
                        }
                    };
                    resultMap.put("successList", successList);
                    resultMap.put("failList", failList);
                } catch (Exception e) {
                    resultMap.put("error", "表格格式错误！");
                }
            } else {
                resultMap.put("error", "没有导入任何数据！");
            }
        }catch(Exception e) {
            resultMap.put("error", "文件格式错误！");
        } finally {
            return resultMap;
        }
    }

    public Income getIncome(String id) {
        return incomeDao.getIncome(id);
    }

    public Income getIncomeByTaxId(String taxId) {
        return incomeDao.getIncomeByTaxId(taxId);
    }

    public List<Income> getIncomes() {
        return incomeDao.getIncomes();
    }

    @Transactional
    public IncomeDto createIncome(Income income) {
        IncomeDto createIncomeDto;

        // 进项查重
        if (income.getTaxId() != null && income.getTaxId().length() != 0 && incomeDao.getIncomeByTaxId(income.getTaxId()) != null) {
            createIncomeDto = new IncomeDto(false, "进项已存在");
            return createIncomeDto;
        }

        // 完善进项信息
        String incomeId = UUIDGeneratorUtil.getUUID();
        income.setId(incomeId);

        String now = TimeUtil.now();
        income.setCreated_at(now);
        income.setUpdated_at(now);
        if(income.getTaxId() != null && income.getTaxId().length() == 0) { income.setTaxId(null); }

        // 插入数据库失败
        if (!incomeDao.createIncome(income)) {
            createIncomeDto = new IncomeDto(false, "创建失败");
            return createIncomeDto;
        }

        // 成功创建
        createIncomeDto = new IncomeDto(true, income);
        return createIncomeDto;
    }

    public IncomeDto modifyIncomeInfo(Income income) {
        Income oldIncome = incomeDao.getIncome(income.getId());
        if(oldIncome == null) {
            return new IncomeDto(false, "进项不存在");
        }
        oldIncome.setTaxId(income.getTaxId());
        oldIncome.setInType(income.getInType());
        oldIncome.setMoney(income.getMoney());
        oldIncome.setTaxDate(income.getTaxDate());
        oldIncome.setUpdated_at(TimeUtil.now());
        if(!incomeDao.updateIncomeInfo(oldIncome)) {
            return new IncomeDto(false, "更新进项信息失败");
        }
        return new IncomeDto(true, oldIncome);
    }

    public IncomeDto createIncomeForce(Income income, User user) {
        String now = TimeUtil.now();
        income.setCreated_at(now);
        income.setUpdated_at(now);
        income.setUid(user.getId());
        Income oldIncome = incomeDao.getIncomeByTaxId(income.getTaxId());
        if(oldIncome != null) {
            income.setId(oldIncome.getId());
            income.setCreated_at(TimeUtil.now());
            return modifyIncomeInfo(income);
        } else {
            return createIncome(income);
        }
    }

    public boolean deleteIncome(Income income) {
        return incomeDao.deleteIncome(income);
    }

    public List<String> searchIncomeList(HttpServletRequest request){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        try {
            if (request.getParameter("type") != null) {
                paramsMap.put("type", new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8"));
            }
            if (request.getParameter("limit") != null) {
                String page = request.getParameter("page");
                if (page == null) { page = "1"; }
                paramsMap.put("page", page);
                paramsMap.put("limit", request.getParameter("limit"));
            }
            paramsMap.put("beginTime", request.getParameter("beginTime"));
            paramsMap.put("endTime", request.getParameter("endTime"));
            paramsMap.put("taxId", request.getParameter("taxId"));
            paramsMap.put("minMoney", request.getParameter("minMoney"));
            paramsMap.put("maxMoney", request.getParameter("maxMoney"));
            paramsMap.put("createdBegin", request.getParameter("createdBegin"));
            paramsMap.put("createdEnd", request.getParameter("createdEnd"));
            paramsMap.put("userId", request.getParameter("userId"));
            paramsMap.put("orderBy", request.getParameter("orderBy"));
        } catch (Exception e) {

        } finally {
            return incomeDao.searchIncomeList(paramsMap);
        }
    }

    public List calculate(HttpServletRequest request) {
        // 第一步， 先根据条件获取进项数据
        List incomeList = searchIncomeList(request);

        // 第二步， 处理返回的数据, 按月份划分...
        incomeList.remove(0);
        float[] list = splitData(incomeList);

        // 第三步， 根据结果进行预测计算

        PlainDataAnalysis analysis = new PlainDataAnalysis();           //建立一元线性回归预测模型

        for(int i = 0; i < list.length; i ++) {
            analysis.AddData(i + 1, list[i]); //填入数据，并自动优化模型
        }

        List returnist = new LinkedList();
        try {
            for(int i = 0; i < list.length; i ++) {
                double data = analysis.GetData(i + 12);
                if (String.valueOf(data) == "NaN" || data < 0) { data = 0; }
                returnist.add(i, data);
            }
            returnist.add(12, analysis.GetR2());
        } catch (Exception e) {

        } finally {
            return returnist;
        }
    }

    public List<String> typeList() {
        return incomeDao.typeList();
    };

    private float[] splitData(List incomeList) {
        float[] list = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};;
        Income income = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        int month;

        Iterator it = incomeList.iterator();
        while(it.hasNext()) {
            income = (Income)it.next();
            try {
                date = sdf.parse(income.getTaxDate());
                month = date.getMonth();
                list[((month-6)+12)%12 + 1] += income.getMoney(); // 进行月份映射
                out.println("输出月份-------------------------------------------");
                out.println(income.getTaxDate());
                out.println(((month-6)+12)%12 + 1);
            } catch(Exception e) {
                out.println("输出报错-------------------------------------------");
                out.println(e);
            }
        }
        return list;
    }

    public double getTax(HttpServletRequest request) {
        //  Standard,Simplified,Prepayment
        List incomeList = searchIncomeList(request);
        List outcomeList = outcomeService.searchOutcomeList(request);
        incomeList.remove(0);
        outcomeList.remove(0);
        double incomeMoney = getIncomeMoney(incomeList);
        double outcomeMoney = getOutcomeMoney(outcomeList);

        TaxCalculator taxc;
        int TaxType = Integer.parseInt(request.getParameter("taxType") == null ? "0" : (String)request.getParameter("taxType"));
        float taxRate = Float.parseFloat(request.getParameter("taxRate") == null ? "0.17" : (String)request.getParameter("taxRate"));
        boolean hasTax = Boolean.parseBoolean(request.getParameter("hasTax"));
        switch (TaxType) {
            case 1: taxc = new TaxCalculator(VATType.Simplified, taxRate); break;
            case 2: taxc = new TaxCalculator(VATType.Prepayment, taxRate); break;
            default: taxc = new TaxCalculator(VATType.Standard, taxRate);
        }
        double tax = 0;
        if(hasTax) {
//            out.println("输出进项值--------------------------");
//            out.println(incomeMoney);
//            out.println("输出销项值--------------------------");
//            out.println(outcomeMoney);
            tax = taxc.getTax(incomeMoney, outcomeMoney);
        } else {
            tax = taxc.getTaxRawCost(incomeMoney, outcomeMoney);
        }
        return tax;
    }

    private double getIncomeMoney(List list) {
        Iterator it = list.iterator();
        double money = 0;
        while(it.hasNext()) {
            money += ((Income)it.next()).getMoney();
        }
        return  money;
    }

    private double getOutcomeMoney(List list) {
        Iterator it = list.iterator();
        double money = 0;
        while(it.hasNext()) {
            money += ((Outcome)it.next()).getMoney();
        }
        return  money;
    }
}

