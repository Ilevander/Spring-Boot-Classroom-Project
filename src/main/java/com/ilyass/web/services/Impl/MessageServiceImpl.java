package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.MessageDto;
import com.ilyass.web.mapper.MessageMapper;
import com.ilyass.web.models.Message;
import com.ilyass.web.repositories.MessageRepository;
import com.ilyass.web.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageDto> findAllMessages() {
        List<Message> messages = messageRepository.findAll();
        return MessageMapper.mapToMessageDtos(messages);
    }

    @Override
    public MessageDto findMessageById(int messageId) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        return MessageMapper.mapToMessageDto(message);
    }

    @Override
    public void createMessage(MessageDto messageDto) {
        Message message = MessageMapper.mapToMessage(messageDto);
        messageRepository.save(message);
    }

    @Override
    public void updateMessage(int messageId, MessageDto messageDto) {
        Message existingMessage = messageRepository.findById(messageId)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        MessageMapper.updateMessageFromDto(existingMessage, messageDto);
        messageRepository.save(existingMessage);
    }

    @Override
    public void deleteMessage(int messageId) {
        messageRepository.deleteById(messageId);
    }
}
