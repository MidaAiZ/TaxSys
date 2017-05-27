package com.taxcal.taxStrategyImpl;

import com.taxcal.taxStrategy.ICalculateMethod;

/**
 * Created by ZZADD on 2017/5/14.
 */
public class StandardCalculator implements ICalculateMethod {
    private double rate;

    public void setVATRate(double rate) {
        this.rate = rate;
    }

    public void setVATRateSecondary(double rate) throws IllegalAccessException {
        throw new IllegalAccessException("No secondary tax rate needed");
    }

    /**
     * 通过净成本值计算增值税额
     * @param income    净收入
     * @param outcome   净支出
     * @return
     */
    public double getVAT(double income, double outcome)
    {
        return rate * (income - outcome);
    }
    /**
     * 通过税后发票计算增值税额
     * @param income  销项/含税收入
     * @param outcome  进项/含税支出
     * @param isTaxIncluded     是否为含税额
     * @return
     */
    public double getVAT(double income, double outcome, boolean isTaxIncluded) {
        if(isTaxIncluded)
        {
            return rate * (income - outcome) / (1 + rate);
        }
        else
        {
            return getVAT(income, outcome);
        }
    }
}
