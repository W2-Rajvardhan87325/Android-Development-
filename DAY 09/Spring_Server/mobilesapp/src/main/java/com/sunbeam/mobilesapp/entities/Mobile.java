package com.sunbeam.mobilesapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mobiles")
public class Mobile {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="mname")
    private String name;
    private int ram;
    private int storage;
    private String company;
    private double price;
    private String image;
    public Mobile() {
    }
    public Mobile(int id, String name, int ram, int storage, String company, double price, String image) {
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.company = company;
        this.price = price;
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Mobile [id=" + id + ", name=" + name + ", ram=" + ram + ", storage=" + storage + ", company=" + company
                + ", price=" + price + ", image=" + image + "]";
    }
    
}
