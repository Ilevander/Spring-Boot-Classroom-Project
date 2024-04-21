package com.ilyass.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AttendanceDto {

    private int attendanceId;

    private int studentId;

    private int courseId;

    private Date sessionDate;

    private String status;
}
