package com.ilyass.web.services;

import com.ilyass.web.dto.AttendanceDto;

import java.util.Date;
import java.util.List;

public interface AttendanceService {

    List<AttendanceDto> findAllAttendances();

    AttendanceDto findAttendanceById(int attendanceId);

    List<AttendanceDto> findAttendancesByStudentId(int studentId);

    List<AttendanceDto> findAttendancesByCourseId(int courseId);

    List<AttendanceDto> findAttendancesBySessionDate(Date sessionDate);

    List<AttendanceDto> findAttendancesByStatus(String status);

    void createAttendance(AttendanceDto attendanceDto);

    void updateAttendance(int attendanceId, AttendanceDto attendanceDto);

    void deleteAttendance(int attendanceId);
}
