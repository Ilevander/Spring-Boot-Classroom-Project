package com.ilyass.web.services.Impl;

import com.ilyass.web.dto.ResourceDto;
import com.ilyass.web.mapper.ResourceMapper;
import com.ilyass.web.models.Resource;
import com.ilyass.web.repositories.ResourceRepository;
import com.ilyass.web.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<ResourceDto> findAllResources() {
        List<Resource> resources = resourceRepository.findAll();
        return ResourceMapper.mapToResourceDtos(resources);
    }

    @Override
    public ResourceDto findResourceById(int resourceId) {
        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        return ResourceMapper.mapToResourceDto(resource);
    }

    @Override
    public List<ResourceDto> findResourcesByType(String type) {
        List<Resource> resources = resourceRepository.findByType(type);
        return ResourceMapper.mapToResourceDtos(resources);
    }

    @Override
    public List<ResourceDto> findResourcesByAccessibility(String accessibility) {
        List<Resource> resources = resourceRepository.findByAccessibility(accessibility);
        return ResourceMapper.mapToResourceDtos(resources);
    }

    @Override
    public void createResource(ResourceDto resourceDto) {
        Resource resource = ResourceMapper.mapToResource(resourceDto);
        resourceRepository.save(resource);
    }

    @Override
    public void updateResource(int resourceId, ResourceDto resourceDto) {
        Resource existingResource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        ResourceMapper.updateResourceFromDto(existingResource, resourceDto);
        resourceRepository.save(existingResource);
    }

    @Override
    public void deleteResource(int resourceId) {
        resourceRepository.deleteById(resourceId);
    }
}
