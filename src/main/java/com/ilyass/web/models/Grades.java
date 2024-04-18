package com.ilyass.web.models;

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
@Table(name="grade")
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeId;
    private int studentId;
    private int courseId;
    private int assignmentId;
    private int quizId;
    private int examId;
    private int marksObtained;
    private int totalMark;
    private String gradeLetter;
    private String remark;
}
