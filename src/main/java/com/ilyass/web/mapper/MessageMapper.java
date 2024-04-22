package com.ilyass.web.mapper;

import com.ilyass.web.dto.MessageDto;
import com.ilyass.web.models.Message;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MessageMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Message mapToMessage(MessageDto messageDto) {
        return modelMapper.map(messageDto, Message.class);
    }

    public static MessageDto mapToMessageDto(Message message) {
        return modelMapper.map(message, MessageDto.class);
    }

    public static List<Message> mapToMessages(List<MessageDto> messageDtos) {
        return messageDtos.stream()
                .map(dto -> modelMapper.map(dto, Message.class))
                .collect(Collectors.toList());
    }

    public static List<MessageDto> mapToMessageDtos(List<Message> messages) {
        return messages.stream()
                .map(entity -> modelMapper.map(entity, MessageDto.class))
                .collect(Collectors.toList());
    }

    public static void updateMessageFromDto(Message message, MessageDto messageDto) {
        modelMapper.map(messageDto, message);
    }
}
