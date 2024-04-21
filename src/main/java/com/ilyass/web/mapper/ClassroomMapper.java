package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.ClassroomDto;
import com.ilyass.web.models.Classroom;

public class ClassroomMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Classroom mapToClassroom(ClassroomDto classroomDto) {
        return modelMapper.map(classroomDto, Classroom.class);
    }

    public static ClassroomDto mapToClassroomDto(Classroom classroom) {
        return modelMapper.map(classroom, ClassroomDto.class);
    }

    public static List<Classroom> mapToClassrooms(List<ClassroomDto> classroomDtos) {
        return classroomDtos.stream() 
                .map(dto -> modelMapper.map(dto, Classroom.class))
                .collect(Collectors.toList());
    }
 
    public static List<ClassroomDto> mapToClassroomDtos(List<Classroom> classrooms) {
        return classrooms.stream()
                .map(entity -> modelMapper.map(entity, ClassroomDto.class))
                .collect(Collectors.toList());
    }

    public static void updateClassroomFromDto(Classroom classroom, ClassroomDto classroomDto) {
        modelMapper.map(classroomDto, classroom);
    }
}
