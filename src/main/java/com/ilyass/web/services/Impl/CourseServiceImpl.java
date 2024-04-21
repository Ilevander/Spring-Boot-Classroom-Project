package com.ilyass.web.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.CourseDto;
import com.ilyass.web.mapper.CourseMapper;
import com.ilyass.web.models.Course;
import com.ilyass.web.repositories.CourseRepository;
import com.ilyass.web.services.CourseService;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public CourseDto findCourseById(int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.mapToCourseDto(course);
    }

    @Override
    public List<CourseDto> findCoursesByInstructorId(int instructorId) {
        List<Course> courses = courseRepository.findByInstructorId(instructorId);
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public List<CourseDto> findCoursesByStartDate(Date startDate) {
        List<Course> courses = courseRepository.findByStartDate(startDate);
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public List<CourseDto> findCoursesByEndDate(Date endDate) {
        List<Course> courses = courseRepository.findByEndDate(endDate);
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public List<CourseDto> findCoursesByDuration(int duration) {
        List<Course> courses = courseRepository.findByDuration(duration);
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public List<CourseDto> findCoursesBySyllabus(String syllabus) {
        List<Course> courses = courseRepository.findBySyllabus(syllabus);
        return CourseMapper.mapToCourseDtos(courses);
    }

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = CourseMapper.mapToCourse(courseDto);
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(int courseId, CourseDto courseDto) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        CourseMapper.updateCourseFromDto(existingCourse, courseDto);
        courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }
}
