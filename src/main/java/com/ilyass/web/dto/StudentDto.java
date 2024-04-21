package com.ilyass.web.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    private int studentId;
    private String studentName;
    private String email;
    private String phone;
    private String address;
    private Date enrollmentDate;
    private String password;
    private String passwordConfirm;
    private List<Integer> coursesEnrolled; 

}
