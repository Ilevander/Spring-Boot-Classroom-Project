package com.ilyass.web.repositories;

import com.ilyass.web.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    List<Assignment> findByAssignmentName(String assignmentName);

    List<Assignment> findByDescription(String description);

    List<Assignment> findByDeadline(Date deadline);

    List<Assignment> findByPoints(int points);

}
  