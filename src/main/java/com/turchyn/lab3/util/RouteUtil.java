package com.turchyn.lab3.util;

import com.turchyn.lab3.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteUtil {
    RouteService routeService;

    @Autowired
    public RouteUtil(RouteService routeService) {
        this.routeService = routeService;
    }
}
