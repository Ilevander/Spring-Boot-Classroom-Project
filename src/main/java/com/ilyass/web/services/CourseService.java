package com.ilyass.web.services;

import com.ilyass.web.dto.CourseDto;

import java.util.Date;
import java.util.List;

public interface CourseService {

    List<CourseDto> findAllCourses();

    CourseDto findCourseById(int courseId);

    List<CourseDto> findCoursesByInstructorId(int instructorId);

    List<CourseDto> findCoursesByStartDate(Date startDate);

    List<CourseDto> findCoursesByEndDate(Date endDate);

    List<CourseDto> findCoursesByDuration(int duration);

    List<CourseDto> findCoursesBySyllabus(String syllabus);

    void createCourse(CourseDto courseDto);

    void updateCourse(int courseId, CourseDto courseDto);

    void deleteCourse(int courseId);
}
