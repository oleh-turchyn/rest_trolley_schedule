package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.Schedule;
import com.turchyn.lab3.model.dto.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    ScheduleDto toDto(Schedule schedule);

    Schedule toSchedule(ScheduleDto scheduleDto);
}
