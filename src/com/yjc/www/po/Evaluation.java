package com.yjc.www.po;

import java.util.Date;

public class Evaluation {
    private Integer id;
    private String comments;
    private Integer exhibitionHallId;
    private Integer visitorId;
    private Date commitTime;
    private String star;

    public Evaluation(Integer id, String comments, Integer exhibitionHallId, Integer visitorId, Date commitTime, String star) {
        this.id = id;
        this.comments = comments;
        this.exhibitionHallId = exhibitionHallId;
        this.visitorId = visitorId;
        this.commitTime = commitTime;
        this.star = star;
    }

    public Evaluation(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getExhibitionHallId() {
        return exhibitionHallId;
    }

    public void setExhibitionHallId(Integer exhibitionHallId) {
        this.exhibitionHallId = exhibitionHallId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "evaluation{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                ", exhibitionHallId=" + exhibitionHallId +
                ", visitorId=" + visitorId +
                ", commitTime=" + commitTime +
                ", star='" + star + '\'' +
                '}';
    }
}
