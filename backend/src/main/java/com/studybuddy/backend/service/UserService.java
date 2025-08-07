package com.studybuddy.backend.service;

import com.studybuddy.backend.entity.Subject;
import com.studybuddy.backend.entity.User;
import com.studybuddy.backend.repository.SubjectRepository;
import com.studybuddy.backend.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    public UserService(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public Optional<User> addSubjectToUser(UUID userId, UUID subjectId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);

        if (userOpt.isPresent() && subjectOpt.isPresent()) {
            User user = userOpt.get();
            user.getSubjects().add(subjectOpt.get());
            return Optional.of(userRepository.save(user));
        }

        return Optional.empty();
    }
}
