package com.taxcal.Method;

import com.taxcal.taxStrategy.ICalculateMethod;
import com.taxcal.taxStrategyImpl.PrecollectCalculator;
import com.taxcal.taxStrategyImpl.StandardCalculator;
import com.taxcal.taxStrategyImpl.StandardSimpleCalculator;

/**
 * Created by ZZADD on 2017/5/27.
 */

enum VATType{
    Standard,Simplified,Prepayment
}
/**
 * 税率计算
 */
public class TaxCalculator {

    /**
     * 计算逻辑
     */
    private ICalculateMethod method;
    /**
     * 单税率收税方案
     * @param type  税额计算方法
     * @param rate0 税率
     */
    TaxCalculator(VATType type,double rate0)
    {
        switch (type)
        {
            case Standard:
                method = new StandardCalculator();
                break;
            case Prepayment:
                method = new PrecollectCalculator();
                break;
            case Simplified:
                method = new StandardSimpleCalculator();
                break;
        }
        method.setVATRate(rate0);
    }
    void SetVATTaxRate(double rate0)
    {
        method.setVATRate(rate0);
    }
    void SetVATTaxRate(double rate0,double rate1) throws IllegalAccessException
    {
        method.setVATRate(rate0);
        method.setVATRateSecondary(rate1);
    }
    double GetTaxRawCost(double income, double outcome)
    {
        return method.getVAT(income,outcome);
    }
    double GetTax(double income, double outcome)
    {
        return method.getVAT(income,outcome,true);
    }
}
