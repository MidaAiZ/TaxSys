package com.taxsys.calculatorFactory;

import com.taxsys.model.VATCalculateMethod;
import com.taxsys.taxStrategy.ICalculateMethod;

/**
 * Created by ZZADD on 2017/5/14.
 */
public class VATCalculatorFactory {
    public VATCalculatorFactory() {

    }
    public ICalculateMethod CreateCalculator(String desc) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        Class<?> clas = Class.forName(desc);
        ICalculateMethod r = (ICalculateMethod)clas.newInstance();
        return r;
    }
    public ICalculateMethod CreateCalculator(String desc,float argv0) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        ICalculateMethod r = CreateCalculator(desc);
        r.setVATRate(argv0);
        return r;
    }
    public ICalculateMethod CreateCalculator(String desc,float argv0,float argv1) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        ICalculateMethod r = CreateCalculator(desc, argv0);
        r.setVATRateSecondary(argv1);
        return r;
    }
}
