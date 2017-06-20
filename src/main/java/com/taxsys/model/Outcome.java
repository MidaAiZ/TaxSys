package com.taxsys.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "outcome")

public class Outcome {

    @Id
    @GeneratedValue(generator="sid")
    @GenericGenerator(name="sid",strategy="assigned")
    @Column(length = 32)
    private String id;

    @Column(length = 32)
    private String taxId;

    @Column(length = 32)
    private String outType;

    @Column(length = 16)
    private float money;

    @Column(length = 16)
    private String taxDate;

    @Column(length = 32)
    private String uid;

    @Column(length = 16)
    private String created_at;

    @Column(length = 16)
    private String updated_at;

    public Outcome() {
    }

    public Outcome(String taxId, String outType, float money, String taxDate) {
        this.taxId = taxId;
        this.outType = outType;
        this.money = money;
        this.taxDate = taxDate;
    }

    public Outcome(String outType, float money, String taxDate) {
        this.outType = outType;
        this.money = money;
        this.taxDate = taxDate;
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

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "商品：" + outType + "， 销项额： " + money + ", 日期： " + created_at + ", 发票号： " +  taxId + '\n';
    }
}
