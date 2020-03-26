package com.yjc.www.po;

import java.util.Date;

public class Activity {
    private Integer id;
    private String name;
    private String state;
    private String introduction;
    private Integer exhibitionHallId;
    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", introduction='" + introduction + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String exhibition) {
        this.introduction = introduction;
    }

    public Integer getExhibitionHallId() {
        return exhibitionHallId;
    }

    public void setExhibitionHallId(Integer exhibitionHallId) {
        this.exhibitionHallId = exhibitionHallId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Activity(Integer id, String name, String state, String introduction, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.introduction = introduction;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Activity() {
    }
}
