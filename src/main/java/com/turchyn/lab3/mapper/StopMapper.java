package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.StopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StopMapper {
    StopMapper INSTANCE = Mappers.getMapper(StopMapper.class);
    StopMapper toDto(Stop stop);
    Stop toStoppage(StopDto stopDto);
}
