package com.taxsys.model;

/**
 * Created by Sinner on 2017/5/12.
 */

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 此类为User实体类
 */
@Entity
@Table(name = "income")
public class Income {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    double money;
    String date;
    String type;
    String createTime;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
