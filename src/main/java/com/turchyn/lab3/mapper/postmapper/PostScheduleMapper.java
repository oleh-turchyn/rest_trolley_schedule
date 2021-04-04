package com.turchyn.lab3.mapper.postmapper;

import com.turchyn.lab3.model.Schedule;
import com.turchyn.lab3.model.dto.postdto.PostScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface PostScheduleMapper {
    PostScheduleMapper INSTANCE = Mappers.getMapper(PostScheduleMapper.class);

    PostScheduleDto toPostDto(Schedule schedule);

    Schedule postDtoToSchedule(PostScheduleDto postScheduleDto);

    List<PostScheduleDto> scheduleToPostScheduleDtos(List<Schedule> schedules);

    Set<PostScheduleDto> scheduleToPostScheduleDtosSet(List<Schedule> schedules);

    List<Schedule> schedulePostDtoToRoutes(List<PostScheduleDto> scheduleDtos);
}
