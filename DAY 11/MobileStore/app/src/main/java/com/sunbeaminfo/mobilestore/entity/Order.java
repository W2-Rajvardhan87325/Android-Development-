package com.sunbeaminfo.mobilestore.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private int uid;
    private int mid;

    public Order() {
    }

    public Order(int id, int uid, int mid) {
        this.id = id;
        this.uid = uid;
        this.mid = mid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
