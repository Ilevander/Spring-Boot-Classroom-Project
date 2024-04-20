package com.ilyass.web.repositories;

import com.ilyass.web.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    List<Lesson> findByLessonName(String lessonName);

    List<Lesson> findByDescription(String description);

    List<Lesson> findByDuration(int duration);

}
