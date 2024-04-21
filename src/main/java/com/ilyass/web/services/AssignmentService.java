package com.ilyass.web.services;

import com.ilyass.web.dto.AssignmentDto;

import java.util.Date;
import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> findAllAssignments();

    AssignmentDto findAssignmentById(int assignmentId);

    List<AssignmentDto> findAssignmentsByName(String assignmentName);

    List<AssignmentDto> findAssignmentsByDeadline(Date deadline);

    List<AssignmentDto> findAssignmentsByPoints(int points);

    void createAssignment(AssignmentDto assignmentDto);

    void updateAssignment(int assignmentId, AssignmentDto assignmentDto);

    void deleteAssignment(int assignmentId);
}
