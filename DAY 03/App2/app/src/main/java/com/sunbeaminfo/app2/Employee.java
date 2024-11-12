package com.sunbeaminfo.app2;

import java.io.Serializable;

public class Employee implements Serializable {
    private int empId;
    private String name;
    private String email;
    private double salary;

    public Employee(){
    }

    public Employee(int empId, String name, String email, double salary) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
