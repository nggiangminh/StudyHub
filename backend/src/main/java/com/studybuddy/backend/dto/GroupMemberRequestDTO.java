package com.studybuddy.backend.dto;

import java.util.UUID;

// DTO for group member creation request
public class GroupMemberRequestDTO {
    private UUID userId;
    private UUID studyGroupId;
    private String role;

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public UUID getStudyGroupId() { return studyGroupId; }
    public void setStudyGroupId(UUID studyGroupId) { this.studyGroupId = studyGroupId; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
