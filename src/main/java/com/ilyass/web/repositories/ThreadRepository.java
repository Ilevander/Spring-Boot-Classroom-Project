package com.ilyass.web.repositories;

import com.ilyass.web.models.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Integer> {

    List<Thread> findByThreadTitle(String threadTitle);

    List<Thread> findByCreatorId(int creatorId);

    List<Thread> findByCreatedDate(Date createdDate);

}
