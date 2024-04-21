package com.ilyass.web.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThreadDto {

    private int threadId;
    private String threadTitle;
    private int creatorId;
    private Date createdDate;
    private int discussionForumId;
    private List<Integer> messageIds; 

}
