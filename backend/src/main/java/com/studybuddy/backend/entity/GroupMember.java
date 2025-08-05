package com.studybuddy.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "group_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    private String role; // Leader, Member, etc.
}
