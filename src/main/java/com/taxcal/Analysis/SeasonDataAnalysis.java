package com.taxcal.Analysis;

import java.util.ArrayList;
import java.util.List;

public class SeasonDataAnalysis {
    /**
     * 用于预测的数据值
     */
    private List<SeasonData> datas;
    /**
     * 用于校准预测的比率模型
     */
    private List<RegressionLine> lines;

    public SeasonDataAnalysis()
    {
        datas = new ArrayList<SeasonData>();
    }
    public void AddData(SeasonData data) throws IllegalAccessException
    {
        if(datas.isEmpty() || datas.get(0).getCount() == data.getCount())
            datas.add(data);
        else
            throw new IllegalArgumentException("销售分季不统一,已导入模型的每年月数和将要导入模型的月数不一致");
    }

    public double GetR2()
    {
        double s = 1;
        for(RegressionLine i : lines)
        {
            s *= i.getR();
        }
        s = Math.pow(s,1.0/ lines.size());
        return s;
    }

    /**
     * 预测未来年份的各月销售额
     * @param year 指定预测未来第几年的数据，最后一组数据的年份为第0年
     * @return 返回预测结果集
     */
    public SeasonData GetData(int year) throws IllegalAccessException {
        if(lines == null)
            throw new IllegalAccessException("模型尚未被建立，无法进行预测");
        float [] r = new float[datas.get(0).getCount()];    //初始化季度占比列表
        int index = 0;  //循环基本归纳变量
        int yearIndex = datas.size() + year;    //年份基准值
        float sum = 0;          //季度占比矫正变量


        PlainDataAnalysis anal = new PlainDataAnalysis();   //建立年度销量预测模型

        for(SeasonData i : datas)                           //分析年度销量
            anal.AddData(++index, (float) i.getTotal());

        float targetYear = (float) anal.GetData((float) (yearIndex));   //获取年度销量预测值
        index = 0;

        for(RegressionLine i : lines)                           //分析季度占比预测值
        {
            r[index] = i.at(yearIndex);
            sum += r[index++];
        }

        for(int i = 0;i < r.length; ++i)                    //矫正预测值
        {
            if(r[i] < 0)
                r[i] = 0;
            else
                r[i] /= sum;
            r[i] = targetYear * r[i];                       //写入实值
        }
        return new SeasonData(r);
    }

    /**
     * 建立销售预测模型
     */

    public void CreateModel()
    {
        lines = new ArrayList<RegressionLine>();
        int i,j;
        float cap;

        for(i = 0;i < datas.get(0).getCount(); ++i)
        {
            lines.add(new RegressionLine());
        }

        for(i = 0;i < datas.size(); ++i)
        {
            j = 0;
            while(j < datas.get(i).getCount())
            {
                cap = 100f * datas.get(i).getData(j) / (float)datas.get(i).getTotal();
                lines.get(j).addDataPoint(new DataPoint(i + 1, cap));
                j++;
            }
        }
    }
}
