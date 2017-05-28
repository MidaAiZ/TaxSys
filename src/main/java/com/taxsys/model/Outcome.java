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
    private String created_at;

    public Outcome() {
    }

    public Outcome(String taxId, String outType, float money, String created_at) {
        this.taxId = taxId;
        this.outType = outType;
        this.money = money;
        this.created_at = created_at;
    }

    public Outcome(String taxId, String outType, float money) {
        this.taxId = taxId;
        this.outType = outType;
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
