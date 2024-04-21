package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.DiscussionForumDto;
import com.ilyass.web.models.DiscussionForum;

public class DiscussionForumMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static DiscussionForum mapToDiscussionForum(DiscussionForumDto discussionForumDto) {
        return modelMapper.map(discussionForumDto, DiscussionForum.class);
    }

    public static DiscussionForumDto mapToDiscussionForumDto(DiscussionForum discussionForum) {
        return modelMapper.map(discussionForum, DiscussionForumDto.class);
    }

    public static List<DiscussionForum> mapToDiscussionForums(List<DiscussionForumDto> discussionForumDtos) {
        return discussionForumDtos.stream() 
                .map(dto -> modelMapper.map(dto, DiscussionForum.class))
                .collect(Collectors.toList());
    }
 
    public static List<DiscussionForumDto> mapToDiscussionForumDtos(List<DiscussionForum> discussionForums) {
        return discussionForums.stream()
                .map(entity -> modelMapper.map(entity, DiscussionForumDto.class))
                .collect(Collectors.toList());
    }

    public static void updateDiscussionForumFromDto(DiscussionForum discussionForum, DiscussionForumDto discussionForumDto) {
        modelMapper.map(discussionForumDto, discussionForum);
    }
}
