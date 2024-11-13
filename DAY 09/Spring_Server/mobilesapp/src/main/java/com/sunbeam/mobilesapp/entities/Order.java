package com.sunbeam.mobilesapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
public class Order {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int id;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="uid")
    private User user;
    @ManyToOne
    @JoinColumn(name="mid")
    private Mobile mobile;
    public Order() {
    }
    public Order(int id, User user, Mobile mobile) {
        this.id = id;
        this.user = user;
        this.mobile = mobile;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Mobile getMobile() {
        return mobile;
    }
    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", user=" + user + ", mobile=" + mobile + "]";
    }
}
