package com.ilyass.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AssignmentDto {

    private int assignmentId;

    private String assignmentName;

    private String description;

    private Date deadline;

    private int points;
}
