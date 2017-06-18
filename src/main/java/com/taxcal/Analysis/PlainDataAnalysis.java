package com.taxcal.Analysis;

/**
 * Created by ZZADD on 2017/6/8.
 */
public class PlainDataAnalysis {
    private RegressionLine line;
    private boolean AnalysisAvaliable;
    public PlainDataAnalysis()
    {
        line = new RegressionLine();
        AnalysisAvaliable = false;
    }
    public void AddData(float index,float value)
    {
        line.addDataPoint(new DataPoint(index,value));
        AnalysisAvaliable = line.getDataPointCount() > 1;
    }
    public double GetData(float index)
    {
        return line.getA1() * index + line.getA0();
    }
    public double GetR2()
    {
        return line.getR();
    }
}
