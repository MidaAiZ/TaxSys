package com.taxcal.taxStrategyImpl;

import com.taxcal.taxStrategy.ICalculateMethod;

/**
 * Created by ZZADD on 2017/5/14.
 */
public class ComplexSimpleCalculator implements ICalculateMethod {
    /**
     * 设置主要税率参数
     *
     * @param rate 税率值
     */
    public void setVATRate(double rate) {

    }

    /**
     * 设置次要税率参数
     *
     * @param rate 税率值
     * @throws IllegalAccessException
     */
    public void setVATRateSecondary(double rate) throws IllegalAccessException {

    }

    /**
     * 通过净成本值计算增值税额
     *
     * @param income  净收入
     * @param outcome 净支出
     * @return
     */
    public double getVAT(double income, double outcome) {
        return 0;
    }

    /**
     * 通过税后发票计算增值税额
     *
     * @param income        销项/含税收入
     * @param outcome       进项/含税支出
     * @param isTaxIncluded 是否为含税额
     * @return
     */
    public double getVAT(double income, double outcome, boolean isTaxIncluded) {
        return 0;
    }
}
