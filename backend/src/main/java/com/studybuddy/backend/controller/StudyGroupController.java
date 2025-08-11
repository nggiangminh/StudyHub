package com.studybuddy.backend.controller;

import com.studybuddy.backend.entity.StudyGroup;
import com.studybuddy.backend.service.StudyGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "*")
public class StudyGroupController {
    private final StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping
    public List<StudyGroup> getAllGroups(){
        return studyGroupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroup> getGroupById(@PathVariable UUID id){
        return studyGroupService.getGroupById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudyGroup createGroup(@RequestBody StudyGroup group){
        return studyGroupService.createGroup(group);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID id){
        studyGroupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
