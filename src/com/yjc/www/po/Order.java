package com.yjc.www.po;

import java.util.Date;

public class Order {
    private Integer id;
    private Date orderTime;
    private Date effectiveTime;
    private Integer visitorId;
    private Integer exhibitionHallId;
    private Double cost;
    private String state;

    public Order(Integer id, Date orderTime, Date effectiveTime, Integer visitorId, Integer exhibitionHallId, Double cost, String state) {
        this.id = id;
        this.orderTime = orderTime;
        this.effectiveTime = effectiveTime;
        this.visitorId = visitorId;
        this.exhibitionHallId = exhibitionHallId;
        this.cost = cost;
        this.state = state;
    }

    public Order(Integer id, Date orderTime, Date effectiveTime, Double cost, String state) {
        this.id = id;
        this.orderTime = orderTime;
        this.effectiveTime = effectiveTime;
        this.cost = cost;
        this.state = state;
    }

    public Order(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTIme) {
        this.effectiveTime = effectiveTime;
    }


    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getExhibitionHallId() {
        return exhibitionHallId;
    }

    public void setExhibitionHallId(Integer exhibitionHallId) {
        this.exhibitionHallId = exhibitionHallId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", effectiveTime=" + effectiveTime +
                ", visitorId=" + visitorId +
                ", exhibitionHallId=" + exhibitionHallId +
                ", cost=" + cost +
                ", state='" + state + '\'' +
                '}';
    }
}
