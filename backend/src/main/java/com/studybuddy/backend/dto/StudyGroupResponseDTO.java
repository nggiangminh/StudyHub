package com.studybuddy.backend.dto;

import java.util.UUID;

// DTO for study group response
public class StudyGroupResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private String schedule;
    private String subjectName; // chỉ trả về tên môn học

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
}
