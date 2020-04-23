package com.example.e_shop;

public class RewardModel {

    private String title;
    private String expriryDate;
    private String coupenBody;

    public RewardModel(String title, String expriryDate, String coupenBody) {
        this.title = title;
        this.expriryDate = expriryDate;
        this.coupenBody = coupenBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpriryDate() {
        return expriryDate;
    }

    public void setExpriryDate(String expriryDate) {
        this.expriryDate = expriryDate;
    }

    public String getCoupenBody() {
        return coupenBody;
    }

    public void setCoupenBody(String coupenBody) {
        this.coupenBody = coupenBody;
    }
}
