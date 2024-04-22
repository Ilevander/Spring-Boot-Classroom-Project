package com.ilyass.web.mapper;

import com.ilyass.web.dto.StudentDto;
import com.ilyass.web.models.Student;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Student mapToStudent(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    public static StudentDto mapToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public static List<Student> mapToStudents(List<StudentDto> studentDtos) {
        return studentDtos.stream()
                .map(dto -> modelMapper.map(dto, Student.class))
                .collect(Collectors.toList());
    }

    public static List<StudentDto> mapToStudentDtos(List<Student> students) {
        return students.stream()
                .map(entity -> modelMapper.map(entity, StudentDto.class))
                .collect(Collectors.toList());
    }

    public static void updateStudentFromDto(Student student, StudentDto studentDto) {
        modelMapper.map(studentDto, student);
    }
}
