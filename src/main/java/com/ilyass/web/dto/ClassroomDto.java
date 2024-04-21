package com.ilyass.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomDto {

    private int classroomId;

    private String classroomName;

    private String location;

    private int capacity;

    private String schedule;

    private String virtualPlatform;
}
