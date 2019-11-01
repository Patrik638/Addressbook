/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupp2.addressbook;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statustable")
public class Status implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "actstatus")
    private String actualStatus;
    
    public Status() {}

    public Status(int id, String actualStatus) {
        this.id = id;
        this.actualStatus = actualStatus;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getActualStatus() {
        return actualStatus;
    }
    public void setActualStatus(String actualStatus) {
        this.actualStatus = actualStatus;
    }
    
}
