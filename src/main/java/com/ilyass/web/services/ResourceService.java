package com.ilyass.web.services;

import com.ilyass.web.dto.ResourceDto;

import java.util.List;

public interface ResourceService {

    List<ResourceDto> findAllResources();

    ResourceDto findResourceById(int resourceId);

    List<ResourceDto> findResourcesByType(String type);

    List<ResourceDto> findResourcesByAccessibility(String accessibility);

    void createResource(ResourceDto resourceDto);

    void updateResource(int resourceId, ResourceDto resourceDto);

    void deleteResource(int resourceId);
}
