package com.ilyass.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private int courseId;
    private String courseName;
    private String description;
    private Date startDate;
    private Date endDate;
    private int duration;
    private int instructorId;
    private String syllabus;
    private List<ResourceDto> resources;
}
