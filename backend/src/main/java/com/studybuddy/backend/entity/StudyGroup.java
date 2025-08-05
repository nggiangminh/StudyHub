package com.studybuddy.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "study_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private String schedule;


    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.ALL)
    private List<GroupMember> members;

    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.ALL)
    private List<Message> messages;


}
