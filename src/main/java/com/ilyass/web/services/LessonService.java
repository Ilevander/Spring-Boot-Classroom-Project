package com.ilyass.web.services;

import com.ilyass.web.dto.LessonDto;

import java.util.List;

public interface LessonService {

    List<LessonDto> findAllLessons();

    LessonDto findLessonById(int lessonId);

    void createLesson(LessonDto lessonDto);

    void updateLesson(int lessonId, LessonDto lessonDto);

    void deleteLesson(int lessonId);
}
