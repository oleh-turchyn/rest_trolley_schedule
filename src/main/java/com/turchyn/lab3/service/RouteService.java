package com.turchyn.lab3.service;

import com.turchyn.lab3.model.Route;

import java.util.List;

public interface RouteService extends AbstractDomainObjectService<Route>{
    List<Route> findAllByNumber(int number);
    Route findByName(String name);
}
