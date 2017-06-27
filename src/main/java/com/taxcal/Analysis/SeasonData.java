package com.taxcal.Analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 二维坐标
 */

public class SeasonData{
    private List<Float> data;
    private double sum;

    public SeasonData(float[] input)
    {
        this.data = new ArrayList<Float>();
        this.sum = 0;
        int i = 0;
        while(i < input.length)
        {
            this.data.add(input[i]);
            i++;
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

    public List<Float> getDataList()
    {
        return data;
    }
}
