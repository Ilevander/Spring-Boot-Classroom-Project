package com.ilyass.web.repositories;

import com.ilyass.web.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByStudentName(String studentName);

    List<Student> findByEmail(String email);

    List<Student> findByPhone(String phone);

    List<Student> findByAddress(String address);

    List<Student> findByEnrollmentDate(Date enrollmentDate);

}
