package com.ilyass.web.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.DiscussionForumDto;
import com.ilyass.web.mapper.DiscussionForumMapper;
import com.ilyass.web.models.DiscussionForum;
import com.ilyass.web.repositories.DiscussionForumRepository;
import com.ilyass.web.services.DiscussionForumService;

import java.util.List;

@Service
public class DiscussionForumServiceImpl implements DiscussionForumService {

    private final DiscussionForumRepository discussionForumRepository;

    @Autowired
    public DiscussionForumServiceImpl(DiscussionForumRepository discussionForumRepository) {
        this.discussionForumRepository = discussionForumRepository;
    }

    @Override
    public List<DiscussionForumDto> findAllDiscussionForums() {
        List<DiscussionForum> discussionForums = discussionForumRepository.findAll();
        return DiscussionForumMapper.mapToDiscussionForumDtos(discussionForums);
    }

    @Override
    public DiscussionForumDto findDiscussionForumById(int forumId) {
        DiscussionForum discussionForum = discussionForumRepository.findById(forumId)
                .orElseThrow(() -> new RuntimeException("Discussion forum not found"));
        return DiscussionForumMapper.mapToDiscussionForumDto(discussionForum);
    }

    @Override
    public List<DiscussionForumDto> findDiscussionForumsByLocation(String location) {
        List<DiscussionForum> discussionForums = discussionForumRepository.findByLocation(location);
        return DiscussionForumMapper.mapToDiscussionForumDtos(discussionForums);
    }

    @Override
    public List<DiscussionForumDto> findDiscussionForumsByCapacity(int capacity) {
        List<DiscussionForum> discussionForums = discussionForumRepository.findByCapacity(capacity);
        return DiscussionForumMapper.mapToDiscussionForumDtos(discussionForums);
    }

    @Override
    public void createDiscussionForum(DiscussionForumDto discussionForumDto) {
        DiscussionForum discussionForum = DiscussionForumMapper.mapToDiscussionForum(discussionForumDto);
        discussionForumRepository.save(discussionForum);
    }

    @Override
    public void updateDiscussionForum(int forumId, DiscussionForumDto discussionForumDto) {
        DiscussionForum existingDiscussionForum = discussionForumRepository.findById(forumId)
                .orElseThrow(() -> new RuntimeException("Discussion forum not found"));
        DiscussionForumMapper.updateDiscussionForumFromDto(existingDiscussionForum, discussionForumDto);
        discussionForumRepository.save(existingDiscussionForum);
    }

    @Override
    public void deleteDiscussionForum(int forumId) {
        discussionForumRepository.deleteById(forumId);
    }
}
