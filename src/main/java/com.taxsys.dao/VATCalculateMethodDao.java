package com.taxsys.dao;

import com.taxsys.model.VATCalculateMethod;

/**
 * Created by ZZADD on 2017/5/14.
 */
public interface VATCalculateMethodDao {
    boolean addVATType(VATCalculateMethod type);
    boolean deleteType(VATCalculateMethod type);
    boolean updateVATType(VATCalculateMethod type);
    VATCalculateMethod getVATType(VATCalculateMethod type);
}
