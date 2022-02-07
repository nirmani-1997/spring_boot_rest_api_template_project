package com.example.demo.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name = "user")
public class User {
//    @Column(name = "id")
    private int id;
    private String name;
    private String contactNo;
    private String temp;

    public User(String name, String contactNo) {
        this.name = name;
        this.contactNo = contactNo;
    }

    public User(String name, String contactNo, String temp) {
        this.name = name;
        this.contactNo = contactNo;
        this.temp = temp;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
