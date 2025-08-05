package com.studybuddy.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.security.auth.Subject;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    private String name;
    private String email;
    private String password;
    private String availableTime;

    @ManyToMany
    @JoinTable(name = "user_subjects", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;
}
