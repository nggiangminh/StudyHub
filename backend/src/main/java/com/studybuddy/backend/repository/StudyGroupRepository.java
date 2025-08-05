package com.studybuddy.backend.repository;

import com.studybuddy.backend.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, UUID> {
}
