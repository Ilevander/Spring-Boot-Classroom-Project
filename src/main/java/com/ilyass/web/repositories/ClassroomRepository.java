package com.ilyass.web.repositories;

/**
 * Using the Repository: In your service or controller classes, 
 * We can then inject and use the ClassroomRepository to perform CRUD operations and other database-related operations on the Classroom entity.
 * Queries methods if you need to perform more specific database operations that are not covered by the default methods provided by JpaRepository.
 */
import com.ilyass.web.models.Classroom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    
	List<Classroom> findByLocation(String location);

    List<Classroom> findByCapacity(int capacity);

    List<Classroom> findByLocationAndCapacity(String location, int capacity);
    
    List<Classroom> findByLocationAndSchedule(String location, String schedule);
}
