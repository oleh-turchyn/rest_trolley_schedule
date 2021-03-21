package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.StopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StopMapper {
    StopMapper INSTANCE = Mappers.getMapper(StopMapper.class);

    StopDto toDto(Stop stop);

    Stop toStop(StopDto stopDto);

    List<StopDto> stopToStopDtos(List<Stop> stops);

    List<Stop> stopDtoToStops(List<StopDto> stopDtos);
}
