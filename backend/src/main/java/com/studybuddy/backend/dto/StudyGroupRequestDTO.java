package com.studybuddy.backend.dto;

import java.util.UUID;

// DTO for study group creation/update request
public class StudyGroupRequestDTO {
    private String name;
    private String description;
    private String schedule;
    private UUID subjectId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public UUID getSubjectId() { return subjectId; }
    public void setSubjectId(UUID subjectId) { this.subjectId = subjectId; }
}
