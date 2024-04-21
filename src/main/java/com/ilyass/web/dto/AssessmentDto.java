package com.ilyass.web.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AssessmentDto {

    private int assessmentId;

    private String assessmentName;

    private String type;

    private int duration;
}
