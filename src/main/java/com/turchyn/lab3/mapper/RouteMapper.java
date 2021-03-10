package com.turchyn.lab3.mapper;

import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.dto.RouteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);

    RouteDto toDto(Route route);

    Route toRoute(RouteDto routeDto);
}
