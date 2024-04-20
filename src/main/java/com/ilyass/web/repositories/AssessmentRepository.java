package com.ilyass.web.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilyass.web.models.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

	List<Assessment> findByAssessmentName(String assessmentName);

    List<Assessment> findByType(String type);

    List<Assessment> findByDuration(int duration);
}
