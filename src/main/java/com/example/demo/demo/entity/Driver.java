package com.example.demo.demo.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "driver")

public class Driver extends User  {

//    @JoinColumn(name = "user_id")
//    private User user;

    private String liscenceNo;
    private Date liscenceExpireDate;



    public Driver(String name, String address, String contactNo, String email, String nic, Date dateOfBirth, Date joinedDate, String userRoll, String password, String liscenceNo, Date liscenceExpireDate) {
        super(name, address, contactNo, email, nic, dateOfBirth, joinedDate, userRoll, password);
        this.liscenceNo = liscenceNo;
        this.liscenceExpireDate = liscenceExpireDate;
    }

    public Driver(int id, String name, String address, String contactNo, String email, String nic, Date dateOfBirth, Date joinedDate, String userRoll, String password, boolean active, String liscenceNo, Date liscenceExpireDate) {
        super(id, name, address, contactNo, email, nic, dateOfBirth, joinedDate, userRoll, password, active);
        this.liscenceNo = liscenceNo;
        this.liscenceExpireDate = liscenceExpireDate;
    }


    public String getLiscenceNo() {
        return liscenceNo;
    }

    public void setLiscenceNo(String liscenceNo) {
        this.liscenceNo = liscenceNo;
    }

    public Date getLiscenceExpireDate() {
        return liscenceExpireDate;
    }

    public void setLiscenceExpireDate(Date liscenceExpireDate) {
        this.liscenceExpireDate = liscenceExpireDate;
    }




    @Override
    public String toString() {
        return "Driver{" +
                "liscenceNo='" + liscenceNo + '\'' +
                ", liscenceExpireDate=" + liscenceExpireDate +
                '}';
    }



}
