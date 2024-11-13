package com.sunbeam.mobilesapp.dtos;

import org.springframework.web.multipart.MultipartFile;

public class MobileForm {
    private int id;
    private String name;
    private int ram;
    private int storage;
    private String company;
    private double price;
    private MultipartFile imageFile;
    
    public MobileForm() {
    }

    public MobileForm(int id, String name, int ram, int storage, String company, double price,
            MultipartFile imageFile) {
        this.id = id;
        this.name = name;
        this.ram = ram;
        this.storage = storage;
        this.company = company;
        this.price = price;
        this.imageFile = imageFile;
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

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "MobileForm [id=" + id + ", name=" + name + ", ram=" + ram + ", storage=" + storage + ", company="
                + company + ", price=" + price + ", imageFile=" + imageFile + "]";
    }
    
    
}
