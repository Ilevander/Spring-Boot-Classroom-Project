package com.ilyass.web.services;

import com.ilyass.web.dto.ThreadDto;

import java.util.Date;
import java.util.List;

public interface ThreadService {

    List<ThreadDto> findAllThreads();

    ThreadDto findThreadById(int threadId);

    List<ThreadDto> findThreadsByTitle(String threadTitle);

    List<ThreadDto> findThreadsByCreatorId(int creatorId);

    List<ThreadDto> findThreadsByCreatedDate(Date createdDate);

    void createThread(ThreadDto threadDto);

    void updateThread(int threadId, ThreadDto threadDto);

    void deleteThread(int threadId);
}
