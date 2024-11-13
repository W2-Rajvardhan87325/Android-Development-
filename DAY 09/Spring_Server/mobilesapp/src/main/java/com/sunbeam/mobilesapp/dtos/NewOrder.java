package com.sunbeam.mobilesapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewOrder {
    @JsonProperty("uid")
    private int userId;
    @JsonProperty("mid")
    private int mobileId;
    
    public NewOrder() {
    }
    public NewOrder(int userId, int mobileId) {
        this.userId = userId;
        this.mobileId = mobileId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getMobileId() {
        return mobileId;
    }
    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }
    @Override
    public String toString() {
        return "NewOrder [userId=" + userId + ", mobileId=" + mobileId + "]";
    }
}
