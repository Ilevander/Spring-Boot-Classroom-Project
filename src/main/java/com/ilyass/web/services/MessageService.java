package com.ilyass.web.services;

import com.ilyass.web.dto.MessageDto;

import java.util.List;

public interface MessageService {

    List<MessageDto> findAllMessages();

    MessageDto findMessageById(int messageId);

    void createMessage(MessageDto messageDto);

    void updateMessage(int messageId, MessageDto messageDto);

    void deleteMessage(int messageId);
}
