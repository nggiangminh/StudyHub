package com.studybuddy.backend.dto;

import java.time.LocalDateTime;
import java.util.UUID;

// DTO for message response
public class MessageResponseDTO {
    private UUID id;
    private String content;
    private LocalDateTime timestamp;
    private String senderName; // chỉ trả về tên người gửi
    private String studyGroupName; // chỉ trả về tên nhóm

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }
    public String getStudyGroupName() { return studyGroupName; }
    public void setStudyGroupName(String studyGroupName) { this.studyGroupName = studyGroupName; }
}
