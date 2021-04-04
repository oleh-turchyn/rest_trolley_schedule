
package com.turchyn.lab3.util;

import com.turchyn.lab3.mapper.StopMapper;
import com.turchyn.lab3.model.dto.RouteDto;
import com.turchyn.lab3.model.dto.ScheduleDto;
import com.turchyn.lab3.model.dto.StopDto;
import com.turchyn.lab3.model.dto.postdto.PostRouteDto;
import com.turchyn.lab3.model.dto.postdto.PostScheduleDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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
    public Set<PostRouteDto> getRoutesByStopName(String stopName) {
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoSet = new HashSet<>();
        routeDtoSet = stopDto.getRoutes();
        Set<PostRouteDto> postRouteDtoSet = new HashSet<>();
        for (RouteDto routeDto : routeDtoSet) {
            postRouteDtoSet.add(new PostRouteDto(routeDto.getId(), routeDto.getNumber(), routeDto.getName(), routeDto.getDays(), routeDto.getPublicTransport()));
        }
        return postRouteDtoSet;
    }
    //який транспорт тут їздить
    public Set<PostTransportDto> getTransportByStopName(String stopName){
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<RouteDto> routeDtoList = stopDto.getRoutes();
        Set<PostTransportDto> transportsDtoSet = new HashSet<>();
        for (RouteDto routeDto:routeDtoList){
            transportsDtoSet.add(routeDto.getPublicTransport());
        }
        return transportsDtoSet;
    }

    public Set<PostScheduleDto> getSchedulesByStopName(String stopName){
        StopDto stopDto = StopMapper.INSTANCE.toDto(stopService.findByName(stopName));
        Set<ScheduleDto> scheduleDtoSet = stopDto.getSchedules();
        Set<PostScheduleDto> postScheduleDtoSet = new LinkedHashSet<>();
        for (ScheduleDto scheduleDto: scheduleDtoSet){
            postScheduleDtoSet.add(new PostScheduleDto(scheduleDto.getId(),scheduleDto.getHours(),scheduleDto.getPublicTransport()));
        }
        return postScheduleDtoSet;

    }
}
