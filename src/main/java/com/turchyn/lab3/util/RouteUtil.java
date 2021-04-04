package com.turchyn.lab3.util;

import com.turchyn.lab3.mapper.RouteMapper;
import com.turchyn.lab3.mapper.postmapper.PostRouteMapper;
import com.turchyn.lab3.model.dto.RouteDto;
import com.turchyn.lab3.model.dto.postdto.PostRouteDto;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class RouteUtil {
    RouteService routeService;

    @Autowired
    public RouteUtil(RouteService routeService) {
        this.routeService = routeService;
    }

    //які зупинки є у маршруту
    public Set<PostStopDto> getStopsByRouteName(String routeName) {
        RouteDto routeDto = RouteMapper.INSTANCE.toDto(routeService.findByName(routeName));
        Set<PostStopDto> postStopDtoSet = new HashSet<>();
        postStopDtoSet = routeDto.getStops();
        return postStopDtoSet;
    }

    //які види транспорту їздять по одному номеру маршруту
    public Set<PostTransportDto> getTransportsByRouteNumber(int routeNumber){
        List<PostRouteDto> postRouteDtosList = PostRouteMapper.INSTANCE.routeToPostRouteDtos(routeService.findAllByNumber(routeNumber));
        Set<PostTransportDto> transportsDtoSet = new HashSet<>();
        for (PostRouteDto postRouteDto:postRouteDtosList){
            transportsDtoSet.add(postRouteDto.getPublicTransport());
        }
        return transportsDtoSet;
    }
}
