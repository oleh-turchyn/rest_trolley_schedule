package com.turchyn.lab3.util;

import com.turchyn.lab3.mapper.PublicTransportMapper;
import com.turchyn.lab3.model.dto.PublicTransportDto;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PublicTransportUtil {
    PublicTransportService publicTransportService;
    RouteUtil routeUtil;

    @Autowired
    public PublicTransportUtil(PublicTransportService publicTransportService, RouteUtil routeUtil) {
        this.publicTransportService = publicTransportService;
        this.routeUtil=routeUtil;
    }
    //дістати зупинки по яких їздить цей транспорт
    public Set<PostStopDto> getStopsByTransportId(int id){
        PublicTransportDto publicTransportDto = PublicTransportMapper.INSTANCE.toDto(publicTransportService.findById(id).get());
        return routeUtil.getStopsByRouteName(publicTransportDto.getRoute().getName());
    }
}
