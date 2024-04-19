package com.ilyass.web.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int courseId;

	@Column(name = "course_name")
    private String courseName;

	@Column(name = "description")
    private String description;

	@Column(name = "start_date")
    private Date startDate;

	@Column(name = "end_date")
    private Date endDate;

	@Column(name = "duration")
    private int duration;

	@Column(name = "instructor_id")
    private int instructorId;

	@Column(name = "syllabus")
    private String syllabus;

	@OneToMany
	@JoinColumn(name = "course_id")
    private List<Resource> resources;
}
