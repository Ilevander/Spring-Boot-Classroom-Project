package com.ilyass.web.dto;

import com.ilyass.web.models.Course;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InstructorDto {

    private int instructorId;
    private String instructorName;
    private String email;
    private String phone;
    private String bio;
    private String profilePicture;

    private List<Course> coursesTaught;

    private String password;
    private String passwordConfirm;

}
