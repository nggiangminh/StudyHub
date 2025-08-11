package com.studybuddy.backend.service;

import com.studybuddy.backend.entity.Subject;
import com.studybuddy.backend.entity.User;
import com.studybuddy.backend.repository.SubjectRepository;
import com.studybuddy.backend.repository.UserRepository;
import com.studybuddy.backend.dto.UserRequestDTO;
import com.studybuddy.backend.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    public UserService(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::toUserResponseDTO).collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> getUserById(UUID id) {
        return userRepository.findById(id).map(this::toUserResponseDTO);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = toUserEntity(userRequestDTO);
        User saved = userRepository.save(user);
        return toUserResponseDTO(saved);
    }

    public Optional<UserResponseDTO> addSubjectToUser(UUID userId, UUID subjectId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);

        if (userOpt.isPresent() && subjectOpt.isPresent()) {
            User user = userOpt.get();
            user.getSubjects().add(subjectOpt.get());
            User saved = userRepository.save(user);
            return Optional.of(toUserResponseDTO(saved));
        }

        return Optional.empty();
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    // Mapping methods
    public UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAvailableTime(user.getAvailableTime());
        if (user.getSubjects() != null) {
            dto.setSubjects(user.getSubjects().stream().map(s -> s.getName()).collect(Collectors.toSet()));
        }
        return dto;
    }

    public User toUserEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAvailableTime(dto.getAvailableTime());
        return user;
    }
}
