package com.ilyass.web.repositories;

import com.ilyass.web.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByCourseName(String courseName);

    List<Course> findByDescription(String description);

    List<Course> findByStartDate(Date startDate);

    List<Course> findByEndDate(Date endDate);

    List<Course> findByDuration(int duration);

    List<Course> findByInstructorId(int instructorId);

    List<Course> findBySyllabus(String syllabus);

}
