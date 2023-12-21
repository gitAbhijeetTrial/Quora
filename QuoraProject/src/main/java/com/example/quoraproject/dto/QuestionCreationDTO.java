package com.example.quoraproject.dto;

public class QuestionCreationDTO {
    private String title;
    private String content;
    private Long userId; // The ID of the user who is creating the question

    public QuestionCreationDTO() {
        // Default constructor is required for deserialization
    }

    public QuestionCreationDTO(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

