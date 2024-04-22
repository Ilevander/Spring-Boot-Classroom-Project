package com.ilyass.web.services;

import com.ilyass.web.dto.InstructorDto;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> findAllInstructors();

    InstructorDto findInstructorById(int instructorId);

    List<InstructorDto> findInstructorsByName(String instructorName);

    void createInstructor(InstructorDto instructorDto);

    void updateInstructor(int instructorId, InstructorDto instructorDto);

    void deleteInstructor(int instructorId);
}
