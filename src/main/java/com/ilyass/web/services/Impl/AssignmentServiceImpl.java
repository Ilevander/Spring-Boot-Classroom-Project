package com.ilyass.web.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.AssignmentDto;
import com.ilyass.web.mapper.AssignmentMapper;
import com.ilyass.web.models.Assignment;
import com.ilyass.web.repositories.AssignmentRepository;
import com.ilyass.web.services.AssignmentService; 

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public List<AssignmentDto> findAllAssignments() {
        List<Assignment> assignments = assignmentRepository.findAll();
        return AssignmentMapper.mapToAssignmentDtos(assignments); 
    }

    @Override
    public AssignmentDto findAssignmentById(int assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        return AssignmentMapper.mapToAssignmentDto(assignment); 
    }

    @Override
    public List<AssignmentDto> findAssignmentsByName(String assignmentName) {
        List<Assignment> assignments = assignmentRepository.findByAssignmentName(assignmentName);
        return AssignmentMapper.mapToAssignmentDtos(assignments);
    }

    @Override
    public List<AssignmentDto> findAssignmentsByDeadline(Date deadline) {
        List<Assignment> assignments = assignmentRepository.findByDeadline(deadline);
        return AssignmentMapper.mapToAssignmentDtos(assignments); 
    }

    @Override
    public List<AssignmentDto> findAssignmentsByPoints(int points) {
        List<Assignment> assignments = assignmentRepository.findByPoints(points);
        return AssignmentMapper.mapToAssignmentDtos(assignments); 
    }

    @Override
    public void createAssignment(AssignmentDto assignmentDto) {
        Assignment assignment = AssignmentMapper.mapToAssignment(assignmentDto);
        assignmentRepository.save(assignment);
    }

    @Override
    public void updateAssignment(int assignmentId, AssignmentDto assignmentDto) {
        Assignment existingAssignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        Assignment updatedAssignment = AssignmentMapper.mapToAssignment(assignmentDto);
        updatedAssignment.setAssignmentId(existingAssignment.getAssignmentId());
        assignmentRepository.save(updatedAssignment);
    }

    @Override
    public void deleteAssignment(int assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
