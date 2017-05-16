package com.taxsys.dao;

import com.taxsys.model.VATType;

/**
 * Created by ZZADD on 2017/5/14.
 */
public interface VATTypeDao {
    boolean addVATType(VATType type);
    boolean deleteType(VATType type);
    boolean updateVATType(VATType type);
    VATType getVATType(VATType type);
}
