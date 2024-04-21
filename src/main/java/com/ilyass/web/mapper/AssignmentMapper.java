package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.AssignmentDto;
import com.ilyass.web.models.Assignment;

public class AssignmentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Assignment mapToAssignment(AssignmentDto assignmentDto) {
        return modelMapper.map(assignmentDto, Assignment.class);
    }

    public static AssignmentDto mapToAssignmentDto(Assignment assignment) {
        return modelMapper.map(assignment, AssignmentDto.class);
    }

    public static List<Assignment> mapToAssignments(List<AssignmentDto> assignmentDtos) {
        return assignmentDtos.stream() 
                .map(dto -> modelMapper.map(dto, Assignment.class))
                .collect(Collectors.toList());
    }
 
    public static List<AssignmentDto> mapToAssignmentDtos(List<Assignment> assignments) {
        return assignments.stream()
                .map(entity -> modelMapper.map(entity, AssignmentDto.class))
                .collect(Collectors.toList());
    }

    public static void updateAssignmentFromDto(Assignment assignment, AssignmentDto assignmentDto) {
        modelMapper.map(assignmentDto, assignment);
    }
}
