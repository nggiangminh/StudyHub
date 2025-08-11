package com.studybuddy.backend.repository;

import com.studybuddy.backend.entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupMemberRepository extends JpaRepository<GroupMember, UUID> {
    List<GroupMember> findByStudyGroupId(UUID studyGroupId);
}
