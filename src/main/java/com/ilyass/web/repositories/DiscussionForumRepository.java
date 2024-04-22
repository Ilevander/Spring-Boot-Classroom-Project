package com.ilyass.web.repositories;

import com.ilyass.web.models.DiscussionForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionForumRepository extends JpaRepository<DiscussionForum, Integer> {

    List<DiscussionForum> findByForumName(String forumName);

    List<DiscussionForum> findByThreadsThreadIdIn(List<Integer> threadIds);

    List<DiscussionForum> findByLocation(String location);

    List<DiscussionForum> findByCapacity(int capacity);

}
