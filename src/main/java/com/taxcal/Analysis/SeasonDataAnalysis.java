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
    List<RegressionLine> lines;

    public SeasonDataAnalysis()
    {
        datas = new ArrayList<SeasonData>();
    }
    public void AddData(SeasonData data) throws IllegalAccessException
    {
        if(datas.get(0).getCount() == data.getCount())
            datas.add(data);
        else
            throw new IllegalArgumentException("销售分季不统一,已导入模型的每年月数和将要导入模型的月数不一致");
    }

    /**
     * 预测未来年份的各月销售额
     * @param year 指定预测未来第几年的数据，最后一组数据的年份为第0年
     * @return
     */
    public SeasonData GetData(int year)
    {
        float [] r = new float[datas.get(0).getCount()];



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
                lines.get(j).addDataPoint(new DataPoint(i, cap));
            }
        }
    }
}
