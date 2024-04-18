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
@Table(name="assessments")
public class Assessment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int assessmentId;
	    private String assessmentName;
	    private String type;
	    private int duration;
}
