package com.turchyn.lab3.mapper.postmapper;

import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.dto.postdto.PostRouteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface PostRouteMapper {
    PostRouteMapper INSTANCE = Mappers.getMapper(PostRouteMapper.class);

    PostRouteDto toPostDto(Route route);

    Route toRoute(PostRouteDto postRouteDto);

    List<PostRouteDto> routeToPostRouteDtos(List<Route> routes);

    Set<PostRouteDto> routeToPostRouteDtosSet(List<Route> routes);

    List<Route> routeDtoToRoutes(List<PostRouteDto> routeDtos);
}
