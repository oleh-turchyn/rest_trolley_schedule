package com.turchyn.lab3.service.impl;

import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.repository.RouteRepository;
import com.turchyn.lab3.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route save(Route object) {
        return routeRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Optional<Route> findById(Integer id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> findAllByNumber(int number) {
        return routeRepository.findAllByNumber(number);
    }


    @Override
    public Route findByName(String name) {
        return routeRepository.findByName(name);
    }


}
