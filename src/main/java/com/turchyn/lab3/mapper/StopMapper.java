package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.ScheduleDto;
import com.turchyn.lab3.model.dto.StopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface StopMapper {
    StopMapper INSTANCE = Mappers.getMapper(StopMapper.class);

    StopDto toDto(Stop stop);

    Stop toStop(StopDto stopDto);

    List<StopDto> stopToStopDtos(List<Stop> stops);
    Set<StopDto> stopToStopDtosSet(List<Stop> routes);


    List<Stop> stopDtoToStops(List<StopDto> stopDtos);
}
