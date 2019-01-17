package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
public class TwitterMessage {

    private long id;
    private String text;

    public String getMessage() {
        return text;
    }

    public void setMessage(String message) {
        this.text = message;
    }

}
