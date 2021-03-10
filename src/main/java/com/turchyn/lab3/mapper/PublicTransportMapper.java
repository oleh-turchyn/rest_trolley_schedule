package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.PublicTransport;
import com.turchyn.lab3.model.dto.PublicTransportDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicTransportMapper {

    PublicTransportMapper INSTANCE = Mappers.getMapper(PublicTransportMapper.class);

    PublicTransportDto toDto(PublicTransport publicTransport);

    PublicTransport toPublicTransport(PublicTransportDto publicTransportDto);

}
