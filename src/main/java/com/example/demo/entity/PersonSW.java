package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class PersonSW {

    String name;
    String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
