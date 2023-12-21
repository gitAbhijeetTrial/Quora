package com.example.quoraproject.dto;

public class AnswerCreationDTO {

    private String content;
    private Long userId; // The ID of the user who is creating the answer

    public AnswerCreationDTO(String content, Long userId) {
        this.content = content;
        this.userId = userId;
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
