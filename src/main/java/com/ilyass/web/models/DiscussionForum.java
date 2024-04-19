package com.ilyass.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "discussionForum")
    private List<Thread> threads;


}
