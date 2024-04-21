package com.ilyass.web.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.AssessmentDto;
import com.ilyass.web.mapper.AssessmentMapper;
import com.ilyass.web.models.Assessment;
import com.ilyass.web.repositories.AssessmentRepository;
import com.ilyass.web.services.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;

    @Autowired
    public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public List<AssessmentDto> findAllAssessments() {
        List<Assessment> assessments = assessmentRepository.findAll();
        return AssessmentMapper.mapToAssessmentDtos(assessments); 
    }

    @Override
    public AssessmentDto findAssessmentById(int assessmentId) {
        Assessment assessment = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
        return AssessmentMapper.mapToAssessmentDto(assessment); 
    }

    @Override
    public List<AssessmentDto> findAssessmentsByType(String type) {
        List<Assessment> assessments = assessmentRepository.findByType(type);
        return AssessmentMapper.mapToAssessmentDtos(assessments);
    }

    @Override
    public List<AssessmentDto> findAssessmentsByDuration(int duration) {
        List<Assessment> assessments = assessmentRepository.findByDuration(duration);
        return AssessmentMapper.mapToAssessmentDtos(assessments); 
    }

    @Override
    public void deleteAssessment(int assessmentId) {
        assessmentRepository.deleteById(assessmentId);
    }
}
