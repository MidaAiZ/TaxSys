package com.taxcal.Analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZZADD on 2017/6/8.
 */

public class SeasonData{
    private List<Float> data;
    private double sum;
    private static int SeasonCount = 12;

    public static void SetSeasonCount(int c)
    {
        SeasonCount = c;
    }

    public SeasonData(float[] input)
    {
        this.data = new ArrayList<Float>();
        this.sum = 0;
        int i = 0;
        while(i < SeasonCount)
        {
            this.data.add(input[i]);
        }
    }
    public double getTotal(){
        if(sum == 0) {
            for (float i : data) {
                sum += i;
            }
        }
        return sum;
    }
    public float getData(int index)
    {
        return this.data.get(index);
    }
    public int getCount(){return this.data.size(); }
}
