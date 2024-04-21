package com.ilyass.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DiscussionForumDto {

    private int forumId;
    private String forumName;
    private List<ThreadDto> threads;

}
