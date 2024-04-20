package com.ilyass.web.repositories;

import com.ilyass.web.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findBySenderId(int senderId);

    List<Message> findByReceiverId(int receiverId);

    List<Message> findByMessageContent(String messageContent);

    List<Message> findByTimestamp(Date timestamp);
}
