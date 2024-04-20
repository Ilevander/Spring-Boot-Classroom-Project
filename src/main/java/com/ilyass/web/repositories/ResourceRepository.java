package com.ilyass.web.repositories;

import com.ilyass.web.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    List<Resource> findByResourceName(String resourceName);

    List<Resource> findByDescription(String description);

    List<Resource> findByType(String type);

    List<Resource> findByLink(String link);

    List<Resource> findByAccessibility(String accessibility);

}
