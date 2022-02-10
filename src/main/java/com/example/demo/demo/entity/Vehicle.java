package com.example.demo.demo.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "vehicle")
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String vehicleType;
    private String vehicleModel;
    private String colour;
    private String plateNo;
    private String insuranceNo;
    private Date boughtDate;
    private Date serviceDate;
    private Date vehicleLiscenceDate;
    private Date insuranceExpireDate;
    private boolean active = true;



    public Vehicle(String vehicleType, String vehicleModel, String colour, String plateNo, String insuranceNo, Date boughtDate, Date serviceDate, Date vehicleLiscenceDate, Date insuranceExpireDate) {

    }

    public Vehicle(int vehicleId, String vehicleType, String vehicleModel, String colour, String plateNo, String insuranceNo, Date boughtDate, Date serviceDate, Date vehicleLiscenceDate, Date insuranceExpireDate, boolean active) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.colour = colour;
        this.plateNo = plateNo;
        this.insuranceNo = insuranceNo;
        this.boughtDate = boughtDate;
        this.serviceDate = serviceDate;
        this.vehicleLiscenceDate = vehicleLiscenceDate;
        this.insuranceExpireDate = insuranceExpireDate;
        this.active = active;
    }


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getVehicleLiscenceDate() {
        return vehicleLiscenceDate;
    }

    public void setVehicleLiscenceDate(Date vehicleLiscenceDate) {
        this.vehicleLiscenceDate = vehicleLiscenceDate;
    }

    public Date getInsuranceExpireDate() {
        return insuranceExpireDate;
    }

    public void setInsuranceExpireDate(Date insuranceExpireDate) {
        this.insuranceExpireDate = insuranceExpireDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", colour='" + colour + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", insuranceNo='" + insuranceNo + '\'' +
                ", boughtDate=" + boughtDate +
                ", serviceDate=" + serviceDate +
                ", vehicleLiscenceDate=" + vehicleLiscenceDate +
                ", insuranceExpireDate=" + insuranceExpireDate +
                ", active=" + active +
                '}';
    }
}


