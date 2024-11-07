package com.rajvardhan.app;

import java.io.Serializable;

public class Course implements Serializable {
    private int courseId;
    private String courseName;
    private String courseDescp;
    private Double courseFees;
    private int courseImage;

    public Course() {
    }

    public Course(int courseId, String courseName, String courseDescp, Double courseFees, int courseImage) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescp = courseDescp;
        this.courseFees = courseFees;
        this.courseImage = courseImage;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescp() {
        return courseDescp;
    }

    public void setCourseDescp(String courseDescp) {
        this.courseDescp = courseDescp;
    }

    public Double getCourseFees() {
        return courseFees;
    }

    public void setCourseFees(Double courseFees) {
        this.courseFees = courseFees;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescp='" + courseDescp + '\'' +
                ", courseFees=" + courseFees +
                ", courseImage=" + courseImage +
                '}';
    }
}
