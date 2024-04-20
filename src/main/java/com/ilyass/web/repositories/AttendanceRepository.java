package com.ilyass.web.repositories;

import com.ilyass.web.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findByStudentId(int studentId);

    List<Attendance> findByCourseId(int courseId);

    List<Attendance> findBySessionDate(Date sessionDate);

    List<Attendance> findByStatus(String status);

}
