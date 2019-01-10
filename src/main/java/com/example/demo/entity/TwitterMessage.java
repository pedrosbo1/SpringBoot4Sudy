package com.example.demo.entity;

import org.springframework.stereotype.Component;

public class TwitterMessage {

    String text;

    public String getMessage() {
        return text;
    }

    public void setMessage(String message) {
        this.text = message;
    }

}
