package com.ilyass.web.dto;

import com.ilyass.web.models.Thread;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MessageDto {

    private int messageId;
    private int senderId;
    private int receiverId;
    private String messageContent;
    private Date timestamp;
    private Thread thread;

}
