package com.ilyass.web.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="discussionforums")
public class DiscussionForum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int forumId;
    private String forumName;
    private List<String> topics;
    private List<Thread> threads;
}
