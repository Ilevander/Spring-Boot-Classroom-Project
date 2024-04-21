package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.AssessmentDto;
import com.ilyass.web.models.Assessment;

public class AssessmentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Assessment mapToAssessment(AssessmentDto assessmentDto) {
        return modelMapper.map(assessmentDto, Assessment.class);
    }

    public static AssessmentDto mapToAssessmentDto(Assessment assessment) {
        return modelMapper.map(assessment, AssessmentDto.class);
    }

    public static List<Assessment> mapToAssessments(List<AssessmentDto> assessmentDtos) {
        return assessmentDtos.stream() 
                .map(dto -> modelMapper.map(dto, Assessment.class))
                .collect(Collectors.toList());
    }
 
    public static List<AssessmentDto> mapToAssessmentDtos(List<Assessment> assessments) {
        return assessments.stream()
                .map(entity -> modelMapper.map(entity, AssessmentDto.class))
                .collect(Collectors.toList());
    }
}
   