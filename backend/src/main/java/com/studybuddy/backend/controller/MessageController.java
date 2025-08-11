package com.studybuddy.backend.controller;

import com.studybuddy.backend.entity.Message;
import com.studybuddy.backend.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "*")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/group/{groupId}")
    public List<Message> getMessageByGroupId(@PathVariable UUID groupId) {
        return messageService.getMessageByGroupId(groupId);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
