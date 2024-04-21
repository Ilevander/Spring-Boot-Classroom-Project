package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.CourseDto;
import com.ilyass.web.models.Course;

public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Course mapToCourse(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }

    public static CourseDto mapToCourseDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    public static List<Course> mapToCourses(List<CourseDto> courseDtos) {
        return courseDtos.stream()
                .map(dto -> modelMapper.map(dto, Course.class))
                .collect(Collectors.toList());
    }

    public static List<CourseDto> mapToCourseDtos(List<Course> courses) {
        return courses.stream()
                .map(entity -> modelMapper.map(entity, CourseDto.class))
                .collect(Collectors.toList());
    }

    public static void updateCourseFromDto(Course course, CourseDto courseDto) {
        modelMapper.map(courseDto, course);
    }
}
