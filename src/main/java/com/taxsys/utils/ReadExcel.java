package com.taxsys.utils;

import com.taxsys.model.Income;
import com.taxsys.model.Outcome;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ReadExcel {
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }

    /**
     * 读EXCEL文件，获取信息集合
     * @param: fielName
     * @return
     */
    public List getExcelInfo(MultipartFile mFile, String type) {
        String fileName = mFile.getOriginalFilename();//获取文件名
        List list = null;
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            list = createExcel(mFile.getInputStream(), type, isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("文件错误");
        }
        return list;
    }

    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List createExcel(InputStream is, String type, boolean isExcel2003) {
        List list = null;

        try{
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }

            if (type == "income") {
                list = readIncomeExcelValue(wb);// 读取Excel里面客户的信息
            } else {
                list = readOutcomeExcelValue(wb);// 读取Excel里面客户的信息
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */

    private List<Income> readIncomeExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Income> incomeList = new ArrayList<Income>();
        // 初始化时设置 日期和时间模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // 修改日期和时间模式
        sdf.applyPattern("yyyy/MM/dd");
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            Income income = new Income();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        //如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String name = String.valueOf(cell.getNumericCellValue());
                            income.setTaxId(name.substring(0, name.length()-2>0?name.length()-2:1));//名称
                        }else{
                            income.setTaxId(cell.getStringCellValue());//名称
                        }
                    } else if (c == 1) {
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String sex = String.valueOf(cell.getNumericCellValue());
                            income.setInType(sex.substring(0, sex.length()-2>0?sex.length()-2:1));
                        }else{
                            income.setInType(cell.getStringCellValue());
                        }
                    } else if (c == 2){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String age = String.valueOf(cell.getNumericCellValue());
                            income.setMoney(Integer.parseInt(age.substring(0, age.length()-2>0?age.length()-2:1)));//年龄
                        }else{
                            income.setMoney(Integer.parseInt(cell.getStringCellValue()));
                        }
                    }else if (c == 3){
                        String date = sdf.format(cell.getDateCellValue());
                        income.setCreated_at(date);//年龄
                    }
                }
            }
            // 添加到list
            incomeList.add(income);
        }
        return incomeList;
    }


    private List<Outcome> readOutcomeExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<Outcome> outcomeList = new ArrayList<Outcome>();
        // 初始化时设置 日期和时间模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // 修改日期和时间模式
        sdf.applyPattern("yyyy/MM/dd");
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            Outcome outcome = new Outcome();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        //如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String name = String.valueOf(cell.getNumericCellValue());
                            outcome.setTaxId(name.substring(0, name.length()-2>0?name.length()-2:1));//名称
                        }else{
                            outcome.setTaxId(cell.getStringCellValue());//名称
                        }
                    } else if (c == 1) {
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String sex = String.valueOf(cell.getNumericCellValue());
                            outcome.setOutType(sex.substring(0, sex.length()-2>0?sex.length()-2:1));
                        }else{
                            outcome.setOutType(cell.getStringCellValue());
                        }
                    } else if (c == 2){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String age = String.valueOf(cell.getNumericCellValue());
                            outcome.setMoney(Integer.parseInt(age.substring(0, age.length()-2>0?age.length()-2:1)));//年龄
                        }else{
                            outcome.setMoney(Integer.parseInt(cell.getStringCellValue()));
                        }
                    }else if (c == 3){
                        String date = sdf.format(cell.getDateCellValue());
                        outcome.setCreated_at(date);//年龄
                    }
                }
            }
            // 添加到list
            outcomeList.add(outcome);
        }
        return outcomeList;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}