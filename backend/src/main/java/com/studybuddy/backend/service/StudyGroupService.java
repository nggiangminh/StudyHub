package com.studybuddy.backend.service;

import com.studybuddy.backend.entity.StudyGroup;
import com.studybuddy.backend.repository.StudyGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudyGroupService {
    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupService(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<StudyGroup> getAllGroups(){
        return studyGroupRepository.findAll();
    }

    public Optional<StudyGroup> getGroupById(UUID id){
        return studyGroupRepository.findById(id);
    }

    public StudyGroup createGroup(StudyGroup group ){
        return studyGroupRepository.save(group);
    }

    public void deleteGroup(UUID id ){
        studyGroupRepository.deleteById(id);
    }

}
