package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class TweeterMessage {

    String text;

    public String getMessage() {
        return text;
    }

    public void setMessage(String message) {
        this.text = message;
    }

}
