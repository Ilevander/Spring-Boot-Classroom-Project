package com.ilyass.web.services;

import com.ilyass.web.dto.DiscussionForumDto;

import java.util.List;

public interface DiscussionForumService {

    List<DiscussionForumDto> findAllDiscussionForums();

    DiscussionForumDto findDiscussionForumById(int forumId);

    List<DiscussionForumDto> findDiscussionForumsByLocation(String location);

    List<DiscussionForumDto> findDiscussionForumsByCapacity(int capacity);

    void createDiscussionForum(DiscussionForumDto discussionForumDto);

    void updateDiscussionForum(int forumId, DiscussionForumDto discussionForumDto);

    void deleteDiscussionForum(int forumId);
}


