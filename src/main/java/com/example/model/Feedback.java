package com.example.model;

public class Feedback {
    private Integer feedbackid;

    private Integer userid;

    private String feedbackcontent;

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFeedbackcontent() {
        return feedbackcontent;
    }

    public void setFeedbackcontent(String feedbackcontent) {
        this.feedbackcontent = feedbackcontent == null ? null : feedbackcontent.trim();
    }
}