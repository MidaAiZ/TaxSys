package com.taxsys.model;

/**
 * Created by ZZADD on 2017/5/14.
 */

import javax.persistence.*;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;

public class VATCalculateMethod {

    private int id;
    private String typename;
    private String desc;
    private float taxrate;
    private String className;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    public int getId() {
        return id;
    }
    @Column(length = 32)
    public String getTypename() {
        return typename;
    }
    @Column(length = 128)
    public String getDesc() {
        return desc;
    }
    @Column
    public float getTaxrate() {
        return taxrate;
    }
    @Column(length = 96)
    public String getClassName() {
        return className;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTaxrate(float taxrate) {
        this.taxrate = taxrate;
    }

    public void setClassName(String className) {
        this.className = className;
    }



}
