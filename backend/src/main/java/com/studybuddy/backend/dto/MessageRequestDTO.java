package com.studybuddy.backend.dto;

import java.util.UUID;

// DTO for message creation request
public class MessageRequestDTO {
    private String content;
    private UUID senderId;
    private UUID studyGroupId;

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public UUID getSenderId() { return senderId; }
    public void setSenderId(UUID senderId) { this.senderId = senderId; }
    public UUID getStudyGroupId() { return studyGroupId; }
    public void setStudyGroupId(UUID studyGroupId) { this.studyGroupId = studyGroupId; }
}
