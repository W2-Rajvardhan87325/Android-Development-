package com.rajvardhan.app.entities;

import com.rajvardhan.app.R;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    private int rollNo;
    private String name;
    private String course;
    private int image;

    public Student() {
        this(0,"","", R.drawable.ic_launcher_background);
    }

    public Student(int rollNo, String name, String course, int image) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.image = image;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rollNo);
    }
}
