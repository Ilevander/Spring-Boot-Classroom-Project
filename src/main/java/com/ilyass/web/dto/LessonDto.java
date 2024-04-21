package com.ilyass.web.dto;

import com.ilyass.web.models.Resource;
import lombok.Builder;
import lombok.Data;

import java.util.List;
/*
 * DTO Data Transfer Object
 */
@Data
@Builder
public class LessonDto {

    private int lessonId;
    private String lessonName;
    private String description;
    private int duration;
    private List<Resource> materials;

}
