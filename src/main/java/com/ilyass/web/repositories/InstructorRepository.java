package com.ilyass.web.repositories;

import com.ilyass.web.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    List<Instructor> findByInstructorName(String instructorName);

    List<Instructor> findByEmail(String email);

    List<Instructor> findByPhone(String phone);

    List<Instructor> findByBio(String bio);

    List<Instructor> findByProfilePicture(String profilePicture);

}
