package com.turchyn.lab3.util;

import com.turchyn.lab3.service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicTransportUtil {
    PublicTransportService publicTransportService;
    RouteUtil routeUtil;

    @Autowired
    public PublicTransportUtil(PublicTransportService publicTransportService, RouteUtil routeUtil) {
        this.publicTransportService = publicTransportService;
        this.routeUtil=routeUtil;
    }

}
