package com.ilyass.web.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.ilyass.web.dto.AttendanceDto;
import com.ilyass.web.models.Attendance;

public class AttendanceMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Attendance mapToAttendance(AttendanceDto attendanceDto) {
        return modelMapper.map(attendanceDto, Attendance.class);
    }

    public static AttendanceDto mapToAttendanceDto(Attendance attendance) {
        return modelMapper.map(attendance, AttendanceDto.class);
    }

    public static List<Attendance> mapToAttendances(List<AttendanceDto> attendanceDtos) {
        return attendanceDtos.stream() 
                .map(dto -> modelMapper.map(dto, Attendance.class))
                .collect(Collectors.toList());
    }
 
    public static List<AttendanceDto> mapToAttendanceDtos(List<Attendance> attendances) {
        return attendances.stream()
                .map(entity -> modelMapper.map(entity, AttendanceDto.class))
                .collect(Collectors.toList());
    }

    public static void updateAttendanceFromDto(Attendance attendance, AttendanceDto attendanceDto) {
        modelMapper.map(attendanceDto, attendance);
    }
}
