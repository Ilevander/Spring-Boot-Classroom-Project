package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.StudentDto;
import com.ilyass.web.mapper.StudentMapper;
import com.ilyass.web.models.Student;
import com.ilyass.web.repositories.StudentRepository;
import com.ilyass.web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentMapper.mapToStudentDtos(students);
    }

    @Override
    public StudentDto findStudentById(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(int studentId, StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        StudentMapper.updateStudentFromDto(existingStudent, studentDto);
        studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
