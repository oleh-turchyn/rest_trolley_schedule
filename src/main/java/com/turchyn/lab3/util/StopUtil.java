
package com.turchyn.lab3.util;

import com.turchyn.lab3.mapper.StopMapper;
import com.turchyn.lab3.model.dto.RouteDto;
import com.turchyn.lab3.model.dto.StopDto;
import com.turchyn.lab3.model.dto.postdto.PostRouteDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class StopUtil {
    StopService stopService;

    @Autowired
    public StopUtil(StopService stopService) {
        this.stopService = stopService;
    }

    //у яких маршрутах є ця зупинка
    public Set<PostRouteDto> getRotesByStopName(String stopName) {
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoSet;
        routeDtoSet = stopDto.getRoutes();
        Set<PostRouteDto> postRouteDtoSet = new LinkedHashSet<>();
        for (RouteDto routeDto : routeDtoSet) {
            postRouteDtoSet.add(new PostRouteDto(routeDto.getId(), routeDto.getNumber(), routeDto.getName(), routeDto.getDays(), routeDto.getPublicTransport()));
        }
        return postRouteDtoSet;
    }

    public Set<PostTransportDto> getTransportByStopName(String stopName){
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoList = stopDto.getRoutes();
        Set<PostTransportDto> transportsDtoSet = new LinkedHashSet<>();
        for (RouteDto routeDto:routeDtoList){
            transportsDtoSet.add(routeDto.getPublicTransport());
        }
        return transportsDtoSet;
    }
    //який транспорт тут їздить
}
