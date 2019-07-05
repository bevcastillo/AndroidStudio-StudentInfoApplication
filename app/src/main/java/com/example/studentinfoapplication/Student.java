package com.example.studentinfoapplication;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

    public static ArrayList<Student> studentArrayList = new ArrayList<>();

    private Uri image;
    String lname, fname, course;

    public Student(){      //Add your constructor.

    }


    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
