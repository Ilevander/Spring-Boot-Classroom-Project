package com.ilyass.web.services;

import com.ilyass.web.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAllStudents();

    StudentDto findStudentById(int studentId);

    void createStudent(StudentDto studentDto);

    void updateStudent(int studentId, StudentDto studentDto);

    void deleteStudent(int studentId);
}
