package com.ilyass.web.models;

import java.util.Date;
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
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
    private String studentName;
    private String email;
    private String phone;
    private String address;
    private Date enrollementDate;
    private List<Course> courseEnrolled;
}
