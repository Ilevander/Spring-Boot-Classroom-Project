package com.ilyass.web.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.ClassroomDto;
import com.ilyass.web.mapper.ClassroomMapper;
import com.ilyass.web.models.Classroom;
import com.ilyass.web.repositories.ClassroomRepository;
import com.ilyass.web.services.ClassroomService;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<ClassroomDto> findAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return ClassroomMapper.mapToClassroomDtos(classrooms);
    }

    @Override
    public ClassroomDto findClassroomById(int classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        return ClassroomMapper.mapToClassroomDto(classroom);
    }

    @Override
    public List<ClassroomDto> findClassroomsByLocation(String location) {
        List<Classroom> classrooms = classroomRepository.findByLocation(location);
        return ClassroomMapper.mapToClassroomDtos(classrooms);
    }

    @Override
    public List<ClassroomDto> findClassroomsByCapacity(int capacity) {
        List<Classroom> classrooms = classroomRepository.findByCapacity(capacity);
        return ClassroomMapper.mapToClassroomDtos(classrooms);
    }

    @Override
    public void createClassroom(ClassroomDto classroomDto) {
        Classroom classroom = ClassroomMapper.mapToClassroom(classroomDto);
        classroomRepository.save(classroom);
    }

    @Override
    public void updateClassroom(int classroomId, ClassroomDto classroomDto) {
        Classroom existingClassroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom not found"));
        ClassroomMapper.updateClassroomFromDto(existingClassroom, classroomDto);
        classroomRepository.save(existingClassroom);
    }

    @Override
    public void deleteClassroom(int classroomId) {
        classroomRepository.deleteById(classroomId);
    }
}
