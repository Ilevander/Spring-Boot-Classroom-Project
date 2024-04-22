package com.ilyass.web.mapper;

import com.ilyass.web.dto.InstructorDto;
import com.ilyass.web.models.Instructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class InstructorMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Instructor mapToInstructor(InstructorDto instructorDto) {
        return modelMapper.map(instructorDto, Instructor.class);
    }

    public static InstructorDto mapToInstructorDto(Instructor instructor) {
        return modelMapper.map(instructor, InstructorDto.class);
    }

    public static List<Instructor> mapToInstructors(List<InstructorDto> instructorDtos) {
        return instructorDtos.stream()
                .map(dto -> modelMapper.map(dto, Instructor.class))
                .collect(Collectors.toList());
    }

    public static List<InstructorDto> mapToInstructorDtos(List<Instructor> instructors) {
        return instructors.stream()
                .map(entity -> modelMapper.map(entity, InstructorDto.class))
                .collect(Collectors.toList());
    }

    public static void updateInstructorFromDto(Instructor instructor, InstructorDto instructorDto) {
        modelMapper.map(instructorDto, instructor);
    }
}
