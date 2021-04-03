package com.turchyn.lab3.mapper.postmapper;

import com.turchyn.lab3.model.PublicTransport;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface PostTransportMapper {
    PostTransportMapper INSTANCE = Mappers.getMapper(PostTransportMapper.class);

    PostTransportDto toDto(PublicTransport publicTransport);

    PublicTransport toPublicTransport(PostTransportDto postTransportDto);

    List<PostTransportDto> transportToPostTransportDtos(List<PublicTransport> transports);
//    Set<PublicTransportDto> transportToTransportDtosSet(List<PublicTransport> routes);
//
    List<PublicTransport> postTransportDtoToTransports(List<PostTransportDto> postTransportDtos);
}
