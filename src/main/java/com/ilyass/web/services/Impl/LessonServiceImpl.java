package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.LessonDto;
import com.ilyass.web.mapper.LessonMapper;
import com.ilyass.web.models.Lesson;
import com.ilyass.web.repositories.LessonRepository;
import com.ilyass.web.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<LessonDto> findAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return LessonMapper.mapToLessonDtos(lessons);
    }

    @Override
    public LessonDto findLessonById(int lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        return LessonMapper.mapToLessonDto(lesson);
    }

    @Override
    public void createLesson(LessonDto lessonDto) {
        Lesson lesson = LessonMapper.mapToLesson(lessonDto);
        lessonRepository.save(lesson);
    }

    @Override
    public void updateLesson(int lessonId, LessonDto lessonDto) {
        Lesson existingLesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        LessonMapper.updateLessonFromDto(existingLesson, lessonDto);
        lessonRepository.save(existingLesson);
    }

    @Override
    public void deleteLesson(int lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
