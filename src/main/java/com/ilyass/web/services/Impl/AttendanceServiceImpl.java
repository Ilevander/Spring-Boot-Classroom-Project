package com.ilyass.web.services.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyass.web.dto.AttendanceDto;
import com.ilyass.web.mapper.AttendanceMapper;
import com.ilyass.web.models.Attendance;
import com.ilyass.web.repositories.AttendanceRepository;
import com.ilyass.web.services.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendanceDto> findAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return AttendanceMapper.mapToAttendanceDtos(attendances);
    }

    @Override
    public AttendanceDto findAttendanceById(int attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        return AttendanceMapper.mapToAttendanceDto(attendance);
    }

    @Override
    public List<AttendanceDto> findAttendancesByStudentId(int studentId) {
        List<Attendance> attendances = attendanceRepository.findByStudentId(studentId);
        return AttendanceMapper.mapToAttendanceDtos(attendances);
    }

    @Override
    public List<AttendanceDto> findAttendancesByCourseId(int courseId) {
        List<Attendance> attendances = attendanceRepository.findByCourseId(courseId);
        return AttendanceMapper.mapToAttendanceDtos(attendances);
    }

    @Override
    public List<AttendanceDto> findAttendancesBySessionDate(Date sessionDate) {
        List<Attendance> attendances = attendanceRepository.findBySessionDate(sessionDate);
        return AttendanceMapper.mapToAttendanceDtos(attendances);
    }

    @Override
    public List<AttendanceDto> findAttendancesByStatus(String status) {
        List<Attendance> attendances = attendanceRepository.findByStatus(status);
        return AttendanceMapper.mapToAttendanceDtos(attendances);
    }

    @Override
    public void createAttendance(AttendanceDto attendanceDto) {
        Attendance attendance = AttendanceMapper.mapToAttendance(attendanceDto);
        attendanceRepository.save(attendance);
    }

    @Override
    public void updateAttendance(int attendanceId, AttendanceDto attendanceDto) {
        Attendance existingAttendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        AttendanceMapper.updateAttendanceFromDto(existingAttendance, attendanceDto);
        attendanceRepository.save(existingAttendance);
    }

    @Override
    public void deleteAttendance(int attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }
}
