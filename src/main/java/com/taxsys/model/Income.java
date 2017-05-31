package com.taxsys.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "income")

public class Income {

    @Id
    @GeneratedValue(generator="sid")
    @GenericGenerator(name="sid",strategy="assigned")
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String taxId;

    @Column(length = 32)
    private String inType;

    @Column(length = 16)
    private float money;

    @Column(length = 16)
    private String created_at;

    public Income() {
    }

    public Income(String taxId, String inType, float money, String created_at) {
        this.taxId = taxId;
        this.inType = inType;
        this.money = money;
        this.created_at = created_at;
    }

    public Income(String taxId, String inType, float money) {
        this.taxId = taxId;
        this.inType = inType;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "商品：" + inType + "， 进项额： " + money + ", 日期： " + String.valueOf(created_at) + ", 发票号： " +  taxId + '\n';
    }
}
