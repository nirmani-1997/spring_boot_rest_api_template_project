package com.example.demo.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "user")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)

public class User {
//    @Column(name = "id")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String contactNo;
    private String email;
    private String nic;
    private Date dateOfBirth;
    private Date joinedDate;
    private String userRoll;
    private String password;
    private boolean active = true;

    public User(String name, String address, String contactNo, String email, String nic, Date dateOfBirth, Date joinedDate, String userRoll, String password) {

    }



    //    public User(String name, String contactNo) {
//    }

//    public User(String name, String contactNo) {
//        this.name = name;
//        this.contactNo = contactNo;
//    }

    public User(int id, String name, String address, String contactNo, String email, String nic, Date dateOfBirth, Date joinedDate, String userRoll, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.nic = nic;
        this.dateOfBirth = dateOfBirth;
        this.joinedDate = joinedDate;
        this.userRoll = userRoll;
        this.password = password;
        this.active = active;
    }




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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getUserRoll() {
        return userRoll;
    }

    public void setUserRoll(String userRoll) {
        this.userRoll = userRoll;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joinedDate=" + joinedDate +
                ", userRoll='" + userRoll + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }


}
