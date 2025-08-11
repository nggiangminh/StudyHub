package com.studybuddy.backend.dto;

// DTO for user creation request
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String availableTime;

    // getter & setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAvailableTime() { return availableTime; }
    public void setAvailableTime(String availableTime) { this.availableTime = availableTime; }
}
