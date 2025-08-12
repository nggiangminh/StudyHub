package com.studybuddy.backend.service;

import com.studybuddy.backend.dto.StudyGroupRequestDTO;
import com.studybuddy.backend.dto.StudyGroupResponseDTO;
import com.studybuddy.backend.entity.StudyGroup;
import com.studybuddy.backend.entity.Subject;
import com.studybuddy.backend.repository.StudyGroupRepository;
import com.studybuddy.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;
    private final SubjectRepository subjectRepository;

    public StudyGroupService(StudyGroupRepository studyGroupRepository, SubjectRepository subjectRepository) {
        this.studyGroupRepository = studyGroupRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<StudyGroupResponseDTO> getAllGroups(){
        return studyGroupRepository.findAll().stream().map(this::toStudyGroupResponseDTO).collect(Collectors.toList());
    }

    public Optional<StudyGroupResponseDTO> getGroupById(UUID id){
        return studyGroupRepository.findById(id).map(this::toStudyGroupResponseDTO);
    }

    public StudyGroupResponseDTO createGroup(StudyGroupRequestDTO request){
        StudyGroup group = toStudyGroupEntity(request);
        StudyGroup saved = studyGroupRepository.save(group);
        return toStudyGroupResponseDTO(saved);
    }

    public void deleteGroup(UUID id ){
        studyGroupRepository.deleteById(id);
    }

    // Mapping methods
    public StudyGroupResponseDTO toStudyGroupResponseDTO(StudyGroup group) {
        StudyGroupResponseDTO dto = new StudyGroupResponseDTO();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setDescription(group.getDescription());
        dto.setSchedule(group.getSchedule());
        if (group.getSubject() != null) {
            dto.setSubjectName(group.getSubject().getName());
        }
        return dto;
    }

    public StudyGroup toStudyGroupEntity(StudyGroupRequestDTO dto) {
        StudyGroup group = new StudyGroup();
        group.setName(dto.getName());
        group.setDescription(dto.getDescription());
        group.setSchedule(dto.getSchedule());
        if (dto.getSubjectId() != null) {
            Optional<Subject> subject = subjectRepository.findById(dto.getSubjectId());
            subject.ifPresent(group::setSubject);
        }
        return group;
    }
}
