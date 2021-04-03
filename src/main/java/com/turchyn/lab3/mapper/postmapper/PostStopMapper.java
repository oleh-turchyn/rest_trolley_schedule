package com.turchyn.lab3.mapper.postmapper;

import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

public interface PostStopMapper {
    PostStopMapper INSTANCE = Mappers.getMapper(PostStopMapper.class);

    PostStopDto toPostDto(Stop stop);

    Stop toStop(PostStopDto postStopDto);

    List<PostStopDto> stopToPostStopDtos(List<Stop> stops);

    Set<PostStopDto> stopToPostStopDtosSet(List<Stop> stops);

    List<Stop> stopDtoToStops(List<PostStopDto> stopDtos);

}
