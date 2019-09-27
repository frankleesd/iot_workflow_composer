package com.example.iot_workflow_composor.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {

    @NotBlank(message = "username can't empty!")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}