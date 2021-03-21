package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.dto.BusDto;
import com.turchyn.lab3.model.transport.Bus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BusMapper {
    BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);

    BusDto toDto(Bus bus);

    Bus toBus(BusDto busDto);

    List<BusDto> busToBusDtos(List<Bus> buses);

    List<Bus> busDtoToBuses(List<BusDto> busDtos);
}
