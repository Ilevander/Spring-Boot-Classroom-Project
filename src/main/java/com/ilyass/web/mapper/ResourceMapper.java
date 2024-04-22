package com.ilyass.web.mapper;

import com.ilyass.web.dto.ResourceDto;
import com.ilyass.web.models.Resource;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Resource mapToResource(ResourceDto resourceDto) {
        return modelMapper.map(resourceDto, Resource.class);
    }

    public static ResourceDto mapToResourceDto(Resource resource) {
        return modelMapper.map(resource, ResourceDto.class);
    }

    public static List<Resource> mapToResources(List<ResourceDto> resourceDtos) {
        return resourceDtos.stream()
                .map(dto -> modelMapper.map(dto, Resource.class))
                .collect(Collectors.toList());
    }

    public static List<ResourceDto> mapToResourceDtos(List<Resource> resources) {
        return resources.stream()
                .map(entity -> modelMapper.map(entity, ResourceDto.class))
                .collect(Collectors.toList());
    }

    public static void updateResourceFromDto(Resource resource, ResourceDto resourceDto) {
        modelMapper.map(resourceDto, resource);
    }
}
