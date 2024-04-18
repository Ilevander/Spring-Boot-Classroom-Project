package com.ilyass.web.models;


import java.util.Date;

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
@Table(name="assignments")
public class Assignment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int assignmentId;
	    private String assignmentName;
	    private String description;
	    private Date deadline;
	    private int points;
}
