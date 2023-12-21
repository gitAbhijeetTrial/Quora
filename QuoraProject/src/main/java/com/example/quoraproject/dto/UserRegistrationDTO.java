package com.example.quoraproject.dto;

import java.util.List;

public class UserRegistrationDTO {
    private String username;
    private String password;
    private List<String> selectedTopicNames;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSelectedTopicNames() {
        return selectedTopicNames;
    }

    public void setSelectedTopicNames(List<String> selectedTopicNames) {
        this.selectedTopicNames = selectedTopicNames;
    }
}
