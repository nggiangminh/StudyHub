package com.studybuddy.backend.dto;

import java.util.UUID;

// DTO for group member response
public class GroupMemberResponseDTO {
    private UUID id;
    private String userName; // chỉ trả về tên user
    private String studyGroupName; // chỉ trả về tên nhóm
    private String role;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getStudyGroupName() { return studyGroupName; }
    public void setStudyGroupName(String studyGroupName) { this.studyGroupName = studyGroupName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
