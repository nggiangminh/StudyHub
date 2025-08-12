package com.studybuddy.backend.controller;

import com.studybuddy.backend.dto.GroupMemberRequestDTO;
import com.studybuddy.backend.dto.GroupMemberResponseDTO;
import com.studybuddy.backend.service.GroupMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/group-members")
public class GroupMemberController {

    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<GroupMemberResponseDTO>> getMembersByGroup(@PathVariable UUID groupId) {
        List<GroupMemberResponseDTO> members = groupMemberService.getMembersByGroupId(groupId);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupMemberResponseDTO> getMemberById(@PathVariable UUID id) {
        Optional<GroupMemberResponseDTO> member = groupMemberService.getById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GroupMemberResponseDTO> addMember(@RequestBody GroupMemberRequestDTO request) {
        GroupMemberResponseDTO savedMember = groupMemberService.addMember(request);
        return ResponseEntity.ok(savedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable UUID id) {
        groupMemberService.removeMember(id);
        return ResponseEntity.noContent().build();
    }
}