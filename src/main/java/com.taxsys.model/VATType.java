package com.taxsys.model;

/**
 * Created by ZZADD on 2017/5/14.
 */

import javax.persistence.*;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vattype")
public class VATType {

    private int id;
    private String disc;
    private VATCalculateMethod method;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }
    @Column(length = 128)
    public String getDisc() {
        return disc;
    }
    @ManyToOne(targetEntity = VATCalculateMethod.class)
    @JoinColumn(name = "methodId",referencedColumnName = "id")
    public VATCalculateMethod getMethod() {
        return method;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public void setMethod(VATCalculateMethod method) {
        this.method = method;
    }

}
