package com.example.studentinfoapplication;

import java.io.Serializable;

public class Student implements Serializable {

    private int image;
    private String name, course;

    //getters and setters

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
