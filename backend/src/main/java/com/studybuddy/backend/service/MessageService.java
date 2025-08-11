package com.studybuddy.backend.service;

import com.studybuddy.backend.entity.Message;
import com.studybuddy.backend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessageByGroupId(UUID groupId){
        return messageRepository.findByStudyGroupIdOrderByTimestampAsc(groupId);
    }

    public Message sendMessage(Message message){
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
}
