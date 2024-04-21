package com.ilyass.web.mapper;

import com.ilyass.web.dto.AssessmentDto;
import com.ilyass.web.models.Assessment;

import java.util.stream.Collectors;

public class AssessmentMapper {

    public static Assessment mapToAssessment(AssessmentDto assessmentDto) {
        return Assessment.builder()
                .assessmentId(assessmentDto.getAssessmentId())
                .assessmentName(assessmentDto.getAssessmentName())
                .type(assessmentDto.getType())
                .duration(assessmentDto.getDuration())
                .build();
    }

    public static AssessmentDto mapToAssessmentDto(Assessment assessment) {
        return AssessmentDto.builder()
                .assessmentId(assessment.getAssessmentId())
                .assessmentName(assessment.getAssessmentName())
                .type(assessment.getType())
                .duration(assessment.getDuration())
                .build();
    }
}
