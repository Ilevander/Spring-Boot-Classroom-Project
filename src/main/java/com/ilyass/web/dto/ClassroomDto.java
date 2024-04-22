package com.ilyass.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassroomDto {

    private int classroomId;

    @NotEmpty(message = "Classroom name cannot be empty")
    @Size(max = 100, message = "Classroom name cannot exceed 100 characters")
    private String classroomName;

    @NotEmpty(message = "Location cannot be empty")
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;

    @NotNull(message = "Capacity cannot be null")
    private Integer capacity;

    @NotEmpty(message = "Schedule cannot be empty")
    private String schedule;

    @NotEmpty(message = "Virtual platform cannot be empty")
    private String virtualPlatform;

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }
}
