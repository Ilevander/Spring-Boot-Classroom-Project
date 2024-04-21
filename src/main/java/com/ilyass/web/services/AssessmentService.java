package com.ilyass.web.services;

import com.ilyass.web.dto.AssessmentDto;

import java.util.List;

public interface AssessmentService {

    List<AssessmentDto> findAllAssessments();

    AssessmentDto findAssessmentById(int assessmentId);

    List<AssessmentDto> findAssessmentsByType(String type);

    List<AssessmentDto> findAssessmentsByDuration(int duration);

    void deleteAssessment(int assessmentId);

}
