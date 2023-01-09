package com.example.demo;

import java.io.Serializable;

public class PersonInfo implements Serializable {
    private String fullname;
    private int age;

    public PersonInfo(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
