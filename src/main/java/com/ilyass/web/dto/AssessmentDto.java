package com.ilyass.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto {

    private int assessmentId;

    private String assessmentName;

    private String type;

    private int duration;
}
