package com.ilyass.web.mapper;

import com.ilyass.web.dto.ThreadDto;
import com.ilyass.web.models.Thread;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ThreadMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Thread mapToThread(ThreadDto threadDto) {
        return modelMapper.map(threadDto, Thread.class);
    }

    public static ThreadDto mapToThreadDto(Thread thread) {
        return modelMapper.map(thread, ThreadDto.class);
    }

    public static List<Thread> mapToThreads(List<ThreadDto> threadDtos) {
        return threadDtos.stream()
                .map(dto -> modelMapper.map(dto, Thread.class))
                .collect(Collectors.toList());
    }

    public static List<ThreadDto> mapToThreadDtos(List<Thread> threads) {
        return threads.stream()
                .map(entity -> modelMapper.map(entity, ThreadDto.class))
                .collect(Collectors.toList());
    }

    public static void updateThreadFromDto(Thread thread, ThreadDto threadDto) {
        modelMapper.map(threadDto, thread);
    }
}
