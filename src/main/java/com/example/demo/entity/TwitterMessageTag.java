package com.example.demo.entity;

import java.util.List;

public class TwitterMessageTag {
    private List<TwitterMessage> statuses;


    public List<TwitterMessage> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TwitterMessage> statuses) {
        this.statuses = statuses;
    }
}
