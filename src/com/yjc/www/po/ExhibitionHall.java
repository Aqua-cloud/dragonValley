package com.yjc.www.po;

import java.sql.Timestamp;
import java.util.Date;

public class ExhibitionHall {
    private int id;
    private int masterId;
    private String address;
    private double area;
    private String type;
    private String introduction;
    Timestamp startTime;
    Timestamp endTime;

    @Override
    public String toString() {
        return "showroom{" +
                "id=" + id +
                ", masterId=" + masterId +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }


    public ExhibitionHall(int id, int masterId, String address, double area, String type, String introduction, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.masterId = masterId;
        this.address = address;
        this.area = area;
        this.type = type;
        this.introduction = introduction;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public ExhibitionHall(int id,String address, double area, String type, String introduction, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.type = type;
        this.introduction = introduction;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ExhibitionHall(){

    }

}
