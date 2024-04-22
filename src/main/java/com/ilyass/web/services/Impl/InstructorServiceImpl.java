package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.InstructorDto;
import com.ilyass.web.mapper.InstructorMapper;
import com.ilyass.web.models.Instructor;
import com.ilyass.web.repositories.InstructorRepository;
import com.ilyass.web.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<InstructorDto> findAllInstructors() {
        List<Instructor> instructors = instructorRepository.findAll();
        return InstructorMapper.mapToInstructorDtos(instructors);
    }

    @Override
    public InstructorDto findInstructorById(int instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return InstructorMapper.mapToInstructorDto(instructor);
    }

    @Override
    public List<InstructorDto> findInstructorsByName(String instructorName) {
        List<Instructor> instructors = instructorRepository.findByInstructorName(instructorName);
        return InstructorMapper.mapToInstructorDtos(instructors);
    }

    @Override
    public void createInstructor(InstructorDto instructorDto) {
        Instructor instructor = InstructorMapper.mapToInstructor(instructorDto);
        instructorRepository.save(instructor);
    }

    @Override
    public void updateInstructor(int instructorId, InstructorDto instructorDto) {
        Instructor existingInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        InstructorMapper.updateInstructorFromDto(existingInstructor, instructorDto);
        instructorRepository.save(existingInstructor);
    }

    @Override
    public void deleteInstructor(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }
}
