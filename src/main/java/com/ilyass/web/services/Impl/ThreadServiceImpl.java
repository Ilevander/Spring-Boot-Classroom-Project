package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.ThreadDto;
import com.ilyass.web.mapper.ThreadMapper;
import com.ilyass.web.models.Thread;
import com.ilyass.web.repositories.ThreadRepository;
import com.ilyass.web.services.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    @Autowired
    public ThreadServiceImpl(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    @Override
    public List<ThreadDto> findAllThreads() {
        List<Thread> threads = threadRepository.findAll();
        return ThreadMapper.mapToThreadDtos(threads);
    }

    @Override
    public ThreadDto findThreadById(int threadId) {
        Thread thread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread not found"));
        return ThreadMapper.mapToThreadDto(thread);
    }

    @Override
    public List<ThreadDto> findThreadsByTitle(String threadTitle) {
        List<Thread> threads = threadRepository.findByThreadTitle(threadTitle);
        return ThreadMapper.mapToThreadDtos(threads);
    }

    @Override
    public List<ThreadDto> findThreadsByCreatorId(int creatorId) {
        List<Thread> threads = threadRepository.findByCreatorId(creatorId);
        return ThreadMapper.mapToThreadDtos(threads);
    }

    @Override
    public List<ThreadDto> findThreadsByCreatedDate(Date createdDate) {
        List<Thread> threads = threadRepository.findByCreatedDate(createdDate);
        return ThreadMapper.mapToThreadDtos(threads);
    }

    @Override
    public void createThread(ThreadDto threadDto) {
        Thread thread = ThreadMapper.mapToThread(threadDto);
        threadRepository.save(thread);
    }

    @Override
    public void updateThread(int threadId, ThreadDto threadDto) {
        Thread existingThread = threadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread not found"));
        ThreadMapper.updateThreadFromDto(existingThread, threadDto);
        threadRepository.save(existingThread);
    }

    @Override
    public void deleteThread(int threadId) {
        threadRepository.deleteById(threadId);
    }
}
