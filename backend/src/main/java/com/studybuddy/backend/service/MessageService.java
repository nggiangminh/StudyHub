package com.studybuddy.backend.service;

import com.studybuddy.backend.dto.MessageRequestDTO;
import com.studybuddy.backend.dto.MessageResponseDTO;
import com.studybuddy.backend.entity.Message;
import com.studybuddy.backend.entity.StudyGroup;
import com.studybuddy.backend.entity.User;
import com.studybuddy.backend.repository.MessageRepository;
import com.studybuddy.backend.repository.StudyGroupRepository;
import com.studybuddy.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final StudyGroupRepository studyGroupRepository;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository, StudyGroupRepository studyGroupRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.studyGroupRepository = studyGroupRepository;
    }

    public List<MessageResponseDTO> getMessageByGroupId(UUID groupId){
        return messageRepository.findByStudyGroupIdOrderByTimestampAsc(groupId)
                .stream()
                .map(this::toMessageResponseDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO sendMessage(MessageRequestDTO request){
        Message message = toMessageEntity(request);
        message.setTimestamp(LocalDateTime.now());
        Message saved = messageRepository.save(message);
        return toMessageResponseDTO(saved);
    }

    // Mapping methods
    public MessageResponseDTO toMessageResponseDTO(Message message) {
        MessageResponseDTO dto = new MessageResponseDTO();
        dto.setId(message.getId());
        dto.setContent(message.getContent());
        dto.setTimestamp(message.getTimestamp());
        if (message.getSender() != null) {
            dto.setSenderName(message.getSender().getName());
        }
        if (message.getStudyGroup() != null) {
            dto.setStudyGroupName(message.getStudyGroup().getName());
        }
        return dto;
    }

    public Message toMessageEntity(MessageRequestDTO dto) {
        Message message = new Message();
        message.setContent(dto.getContent());
        if (dto.getSenderId() != null) {
            Optional<User> sender = userRepository.findById(dto.getSenderId());
            sender.ifPresent(message::setSender);
        }
        if (dto.getStudyGroupId() != null) {
            Optional<StudyGroup> group = studyGroupRepository.findById(dto.getStudyGroupId());
            group.ifPresent(message::setStudyGroup);
        }
        return message;
    }
}
