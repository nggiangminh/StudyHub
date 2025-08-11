package com.studybuddy.backend.service;

import com.studybuddy.backend.entity.GroupMember;
import com.studybuddy.backend.repository.GroupMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;

    public GroupMemberService(GroupMemberRepository groupMemberRepository) {
        this.groupMemberRepository = groupMemberRepository;
    }

    public List<GroupMember> getAllMembers() {
        return groupMemberRepository.findAll();
    }

    public List<GroupMember> getMembersByGroupId(UUID groupId) {
        return groupMemberRepository.findByStudyGroupId(groupId);
    }

    public Optional<GroupMember> getById(UUID id) {
        return groupMemberRepository.findById(id);
    }

    public GroupMember addMember(GroupMember member) {
        return groupMemberRepository.save(member);
    }

    public void removeMember(UUID memberId) {
        groupMemberRepository.deleteById(memberId);
    }
}
