package com.taxsys.service.impl;

import com.taxcal.Analysis.PlainDataAnalysis;
import com.taxsys.dao.impl.OutcomeDaoImpl;
import com.taxsys.dto.OutcomeDto;
import com.taxsys.model.Income;
import com.taxsys.model.Outcome;
import com.taxsys.model.User;
import com.taxsys.service.OutcomeService;
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
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    OutcomeDaoImpl outcomeDao;

    public Map<String, Object> readExcelFile(MultipartFile file, User user) {
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        Map<String, Object> resultMap = new HashMap();
        try{
            //解析excel，获取上传的事件单
            List<Outcome> outcomeList = readExcel.getExcelInfo(file, "outcome");
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,

            if (outcomeList.size() == 1 && outcomeList.get(0).equals("ERROR FILE")) {
                resultMap.put("error", "文件格式错误！");
            } else if (outcomeList != null){
                List successList = new LinkedList(); // 添加成功的销项
                List failList = new LinkedList(); // 添加失败的销项

                try{
                    String now = TimeUtil.now();

                    for(Outcome i : outcomeList) {
                        i.setUid(user.getId());
                        try {
                            OutcomeDto outcomeDto = createOutcome(i);
                            if(outcomeDto.isSuccess()){
                                successList.add(outcomeDto.getOutcome());
                            } else {
                                Map failMap = new HashMap<String, Object>();
                                failMap.put("error", outcomeDto.getMessage());
                                failMap.put("outcome", i);
                                failList.add(failMap);
                            }
                        } catch (Exception e) {
                            Map failMap = new HashMap<String, Object>();
                            failMap.put("error", "数据错误！");
                            failMap.put("outcome", i);
                            failList.add(failMap);
                        }
                    };
                    resultMap.put("successList", successList);
                    resultMap.put("failList", failList);
                } catch (Exception e) {
                    resultMap.put("error", "文件格式错误！");
                }
            }else{
                resultMap.put("error", "没有导入任何数据！");
            }
        } catch (Exception e) {
            resultMap.put("error", "文件格式错误！");
        } finally {
            return resultMap;
        }
    }

    public HSSFWorkbook exportExcel(HttpServletRequest request) {
        //以下是从前台获取参数
        int len = 0;
        if(request.getParameter("getTaxId") != null) { len ++; }
        if(request.getParameter("getType") != null) { len ++; }
        if(request.getParameter("getMoney") != null) { len ++; }
        if(request.getParameter("getTaxDate") != null) { len ++; }

        String[] zd = new String[len], col = new String[len];
        int i = 0;
        if(request.getParameter("getTaxId") != null) { zd[i] = "taxId"; col[i] = "销项发票"; i ++; }
        if(request.getParameter("getType") != null) { zd[i] = "outType"; col[i] = "销项类型"; i ++; }
        if(request.getParameter("getMoney") != null) { zd[i] = "money"; col[i] = "金额"; i ++; }
        if(request.getParameter("getTaxDate") != null) { zd[i] = "taxDate"; col[i] = "日期"; }
        try{
            // 获取数据
            List list = searchOutcomeList(request);
            list.remove(0); //总条数信息
            //下面用到上面的类，需要传递实体参数
            ExportExcel<Income> ee = new ExportExcel<Income>();
            //最后一个参数是数据集合
            HSSFWorkbook wb = ee.exportExcel("销项", col, zd, list);
            return wb;
        } catch (Exception e) {
            out.println(e);
            return null;
        }
    }

    public Outcome getOutcome(String id) {
        return outcomeDao.getOutcome(id);
    }

    public Outcome getOutcomeByTaxId(String taxId) {
        return outcomeDao.getOutcomeByTaxId(taxId);
    }

    public LinkedList<Outcome> getOutcomes() {
        return outcomeDao.getOutcomes();
    }

    @Transactional
    public OutcomeDto createOutcome(Outcome outcome) {
        OutcomeDto createOutcomeDto;

        // 销项查重
        if (outcome.getTaxId() != null && outcome.getTaxId().length() != 0 && outcomeDao.getOutcomeByTaxId(outcome.getTaxId()) != null) {
            createOutcomeDto = new OutcomeDto(false, "销项已存在");
            return createOutcomeDto;
        }

        // 完善outcome信息
        String outcomeId = UUIDGeneratorUtil.getUUID();
        outcome.setId(outcomeId);

        String now = TimeUtil.now();
        outcome.setCreated_at(now);
        outcome.setUpdated_at(now);
        if(outcome.getTaxId() != null && outcome.getTaxId().length() == 0) { outcome.setTaxId(null); }

        // 插入数据库失败
        if (!outcomeDao.createOutcome(outcome)) {
            createOutcomeDto = new OutcomeDto(false, "创建失败");
            return createOutcomeDto;
        }

        // 成功创建
        createOutcomeDto = new OutcomeDto(true, outcome);
        return createOutcomeDto;
    }

    public OutcomeDto modifyOutcomeInfo(Outcome outcome) {
        Outcome oldOutcome = outcomeDao.getOutcome(outcome.getId());
        if(oldOutcome == null) {
            return new OutcomeDto(false, "销项不存在");
        }
        oldOutcome.setTaxId(outcome.getTaxId());
        oldOutcome.setOutType(outcome.getOutType());
        oldOutcome.setMoney(outcome.getMoney());
        oldOutcome.setTaxDate(outcome.getTaxDate());
        oldOutcome.setUpdated_at(TimeUtil.now());

        if(!outcomeDao.updateOutcomeInfo(oldOutcome)) {
            return new OutcomeDto(false, "更新销项信息失败");
        }
        return new OutcomeDto(true, oldOutcome);    }

    public OutcomeDto createOutcomeForce(Outcome outcome, User user) {
        String now = TimeUtil.now();
        outcome.setCreated_at(now);
        outcome.setUpdated_at(now);
        outcome.setUid(user.getId());
        Outcome oldOutcome = outcomeDao.getOutcomeByTaxId(outcome.getTaxId());
        if(oldOutcome != null) {
            outcome.setId(oldOutcome.getId());
            outcome.setCreated_at(TimeUtil.now());
            return modifyOutcomeInfo(outcome);
        } else {
            return createOutcome(outcome);
        }
    }


    public boolean deleteOutcome(Outcome outcome) {
        return outcomeDao.deleteOutcome(outcome);
    }

    public List<String> searchOutcomeList(HttpServletRequest request){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        if (page == null) { page = "1"; }
        if (limit == null) { limit = "100"; }
        try{
            if (request.getParameter("type") != null) {
                paramsMap.put("type", new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8"));
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
            paramsMap.put("page", page);
            paramsMap.put("limit", limit);
        } catch (Exception e) {

        } finally {
            return outcomeDao.searchOutcomeList(paramsMap);
        }
    }

    public List calculate(HttpServletRequest request) {
        // 第一步， 先根据条件获取进项数据
        List outcomeList = searchOutcomeList(request);

        // 第二步， 处理返回的数据, 按月份划分...
        outcomeList.remove(0);
        float[] list = splitData(outcomeList);

        // 第三步， 根据结果进行预测计算

        PlainDataAnalysis analysis = new PlainDataAnalysis();           //建立一元线性回归预测模型

        for(int i = 0; i < list.length; i ++) {
            analysis.AddData(i + 1, list[i]); //填入数据，并自动优化模型
        }

        List returnist = new LinkedList();
        for(int i = 0; i < list.length; i ++) {
            out.println("第" + String.valueOf(i + 1) + "个月预测值---------------------------------");
            double data = analysis.GetData(i + 12);
            System.out.println(data);         //获取预测值
            out.println("输出预测准度----------------------------------");
            System.out.println(analysis.GetR2());                           //获取线性相关系数
            returnist.add(i, data);
        }
        returnist.add(12, analysis.GetR2());
        return returnist;
    }

    public List<String> typeList() {
        return outcomeDao.typeList();
    };

    private float[] splitData(List outcomeList) {
        float[] list = new float[12];
        Outcome outcome = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        int month;

        Iterator it = outcomeList.iterator();
        while(it.hasNext()) {
            outcome = (Outcome)it.next();
            try {
                date = sdf.parse(outcome.getTaxDate());
                month = date.getMonth();
                list[((month-6)+12)%12 + 1] += outcome.getMoney(); // 进行月份映射
                out.println("输出月份-------------------------------------------");
                out.println(outcome.getTaxDate());
                out.println(((month-6)+12)%12 + 1);
            } catch(Exception e) {
                out.println("输出报错-------------------------------------------");
                out.println(e);
            }
        }
        return list;
    }
}
