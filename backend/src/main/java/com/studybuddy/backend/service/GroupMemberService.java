package com.studybuddy.backend.service;

import com.studybuddy.backend.dto.GroupMemberRequestDTO;
import com.studybuddy.backend.dto.GroupMemberResponseDTO;
import com.studybuddy.backend.entity.GroupMember;
import com.studybuddy.backend.entity.StudyGroup;
import com.studybuddy.backend.entity.User;
import com.studybuddy.backend.repository.GroupMemberRepository;
import com.studybuddy.backend.repository.StudyGroupRepository;
import com.studybuddy.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;
    private final UserRepository userRepository;
    private final StudyGroupRepository studyGroupRepository;

    public GroupMemberService(GroupMemberRepository groupMemberRepository, UserRepository userRepository, StudyGroupRepository studyGroupRepository) {
        this.groupMemberRepository = groupMemberRepository;
        this.userRepository = userRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<GroupMemberResponseDTO> getAllMembers() {
        return groupMemberRepository.findAll().stream().map(this::toGroupMemberResponseDTO).collect(Collectors.toList());
    }

    public List<GroupMemberResponseDTO> getMembersByGroupId(UUID groupId) {
        return groupMemberRepository.findByStudyGroupId(groupId).stream().map(this::toGroupMemberResponseDTO).collect(Collectors.toList());
    }

    public Optional<GroupMemberResponseDTO> getById(UUID id) {
        return groupMemberRepository.findById(id).map(this::toGroupMemberResponseDTO);
    }

    public GroupMemberResponseDTO addMember(GroupMemberRequestDTO request) {
        GroupMember member = toGroupMemberEntity(request);
        GroupMember saved = groupMemberRepository.save(member);
        return toGroupMemberResponseDTO(saved);
    }

    public void removeMember(UUID memberId) {
        groupMemberRepository.deleteById(memberId);
    }

    // Mapping methods
    public GroupMemberResponseDTO toGroupMemberResponseDTO(GroupMember member) {
        GroupMemberResponseDTO dto = new GroupMemberResponseDTO();
        dto.setId(member.getId());
        dto.setRole(member.getRole());
        if (member.getUser() != null) {
            dto.setUserName(member.getUser().getName());
        }
        if (member.getStudyGroup() != null) {
            dto.setStudyGroupName(member.getStudyGroup().getName());
        }
        return dto;
    }

    public GroupMember toGroupMemberEntity(GroupMemberRequestDTO dto) {
        GroupMember member = new GroupMember();
        member.setRole(dto.getRole());
        if (dto.getUserId() != null) {
            Optional<User> user = userRepository.findById(dto.getUserId());
            user.ifPresent(member::setUser);
        }
        if (dto.getStudyGroupId() != null) {
            Optional<StudyGroup> group = studyGroupRepository.findById(dto.getStudyGroupId());
            group.ifPresent(member::setStudyGroup);
        }
        return member;
    }
}
