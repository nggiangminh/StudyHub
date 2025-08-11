package com.studybuddy.backend.dto;

import java.util.UUID;
import java.util.Set;

// DTO for user response
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String availableTime;
    private Set<String> subjects; // chỉ trả về tên môn học

    // getter & setter
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAvailableTime() { return availableTime; }
    public void setAvailableTime(String availableTime) { this.availableTime = availableTime; }
    public Set<String> getSubjects() { return subjects; }
    public void setSubjects(Set<String> subjects) { this.subjects = subjects; }
}
