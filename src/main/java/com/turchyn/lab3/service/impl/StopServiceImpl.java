package com.turchyn.lab3.service.impl;

import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.repository.StopRepository;
import com.turchyn.lab3.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopServiceImpl implements StopService {
    private final StopRepository stopRepository;

    @Autowired
    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    @Override
    public Stop save(Stop object) {
        return stopRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        stopRepository.deleteById(id);
    }

    @Override
    public Optional<Stop> findById(Integer id) {
        return stopRepository.findById(id);
    }

    @Override
    public List<Stop> findAll() {
        return stopRepository.findAll();
    }
}
