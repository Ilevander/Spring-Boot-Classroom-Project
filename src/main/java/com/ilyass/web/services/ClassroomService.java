package com.ilyass.web.services;

import com.ilyass.web.dto.ClassroomDto;

import java.util.List;

public interface ClassroomService {

    List<ClassroomDto> findAllClassrooms();

    ClassroomDto findClassroomById(int classroomId);

    List<ClassroomDto> findClassroomsByLocation(String location);

    List<ClassroomDto> findClassroomsByCapacity(int capacity);

    void createClassroom(ClassroomDto classroomDto);

    void updateClassroom(int classroomId, ClassroomDto classroomDto);

    void deleteClassroom(int classroomId);
}
