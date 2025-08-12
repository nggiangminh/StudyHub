package com.studybuddy.backend.service;

import com.studybuddy.backend.dto.SubjectRequestDTO;
import com.studybuddy.backend.dto.SubjectResponseDTO;
import com.studybuddy.backend.entity.Subject;
import com.studybuddy.backend.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectResponseDTO> getAllSubjects() {
        return subjectRepository.findAll().stream().map(this::toSubjectResponseDTO).collect(Collectors.toList());
    }

    public Optional<SubjectResponseDTO> getSubjectById(UUID id) {
        return subjectRepository.findById(id).map(this::toSubjectResponseDTO);
    }

    public SubjectResponseDTO createSubject(SubjectRequestDTO request) {
        Subject subject = toSubjectEntity(request);
        Subject saved = subjectRepository.save(subject);
        return toSubjectResponseDTO(saved);
    }

    public void deleteSubject(UUID id) {
        subjectRepository.deleteById(id);
    }

    // Mapping methods
    public SubjectResponseDTO toSubjectResponseDTO(Subject subject) {
        SubjectResponseDTO dto = new SubjectResponseDTO();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        return dto;
    }

    public Subject toSubjectEntity(SubjectRequestDTO dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        return subject;
    }
}
