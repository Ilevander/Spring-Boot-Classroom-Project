package com.ilyass.web.mapper;

import com.ilyass.web.dto.LessonDto;
import com.ilyass.web.models.Lesson;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class LessonMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Lesson mapToLesson(LessonDto lessonDto) {
        return modelMapper.map(lessonDto, Lesson.class);
    }

    public static LessonDto mapToLessonDto(Lesson lesson) {
        return modelMapper.map(lesson, LessonDto.class);
    }

    public static List<Lesson> mapToLessons(List<LessonDto> lessonDtos) {
        return lessonDtos.stream()
                .map(dto -> modelMapper.map(dto, Lesson.class))
                .collect(Collectors.toList());
    }

    public static List<LessonDto> mapToLessonDtos(List<Lesson> lessons) {
        return lessons.stream()
                .map(entity -> modelMapper.map(entity, LessonDto.class))
                .collect(Collectors.toList());
    }

    public static void updateLessonFromDto(Lesson lesson, LessonDto lessonDto) {
        modelMapper.map(lessonDto, lesson);
    }
}
