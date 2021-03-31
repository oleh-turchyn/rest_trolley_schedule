package com.turchyn.lab3.util;

import com.turchyn.lab3.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopUtil {
    StopService stopService;

    @Autowired
    public StopUtil(StopService stopService) {
        this.stopService = stopService;
    }
}
