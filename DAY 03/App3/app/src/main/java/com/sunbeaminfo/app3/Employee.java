package com.sunbeaminfo.app3;

import java.io.Serializable;

public class Employee implements Serializable {
    private int empid;
    private String name;
    private String email;
    private double salary;

    public Employee(){

    }
    public Employee(int empid, String name, String email, double salary) {
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
