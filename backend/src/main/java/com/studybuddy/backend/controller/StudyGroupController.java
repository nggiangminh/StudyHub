package com.studybuddy.backend.controller;

import com.studybuddy.backend.dto.StudyGroupRequestDTO;
import com.studybuddy.backend.dto.StudyGroupResponseDTO;
import com.studybuddy.backend.service.StudyGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<StudyGroupResponseDTO> getAllGroups(){
        return studyGroupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyGroupResponseDTO> getGroupById(@PathVariable UUID id){
        return studyGroupService.getGroupById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudyGroupResponseDTO createGroup(@RequestBody StudyGroupRequestDTO request){
        return studyGroupService.createGroup(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID id){
        studyGroupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
