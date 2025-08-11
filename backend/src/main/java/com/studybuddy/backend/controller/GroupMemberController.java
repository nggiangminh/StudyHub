package com.studybuddy.backend.controller;

import com.studybuddy.backend.entity.GroupMember;
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
    public ResponseEntity<List<GroupMember>> getMembersByGroup(@PathVariable UUID groupId) {
        List<GroupMember> members = groupMemberService.getMembersByGroupId(groupId);
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupMember> getMemberById(@PathVariable UUID id) {
        Optional<GroupMember> member = groupMemberService.getById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GroupMember> addMember(@RequestBody GroupMember member) {
        GroupMember savedMember = groupMemberService.addMember(member);
        return ResponseEntity.ok(savedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable UUID id) {
        groupMemberService.removeMember(id);
        return ResponseEntity.noContent().build();
    }
}