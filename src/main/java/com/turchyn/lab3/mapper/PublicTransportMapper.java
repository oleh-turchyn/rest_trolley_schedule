package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.PublicTransport;
import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.dto.PublicTransportDto;
import com.turchyn.lab3.model.dto.RouteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface PublicTransportMapper {

    PublicTransportMapper INSTANCE = Mappers.getMapper(PublicTransportMapper.class);

    PublicTransportDto toDto(PublicTransport publicTransport);

    PublicTransport toPublicTransport(PublicTransportDto publicTransportDto);

    List<PublicTransportDto> transportToTransportDtos(List<PublicTransport> transports);
    Set<PublicTransportDto> transportToTransportDtosSet(List<PublicTransport> routes);

    List<PublicTransport> transportDtoToTransports(List<PublicTransportDto> transportDtos);
}
