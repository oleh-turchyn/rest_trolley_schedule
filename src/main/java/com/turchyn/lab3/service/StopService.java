package com.turchyn.lab3.service;

import com.turchyn.lab3.model.Stop;

import java.util.List;

public interface StopService extends AbstractDomainObjectService<Stop>{
    Stop findByName(String name);
}
