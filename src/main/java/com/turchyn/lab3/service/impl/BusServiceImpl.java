package com.turchyn.lab3.service.impl;

import com.turchyn.lab3.model.transport.Bus;
import com.turchyn.lab3.repository.BusRepository;
import com.turchyn.lab3.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public void removeById(Integer id) {
        busRepository.deleteById(id);
    }

    @Override
    public Optional<Bus> findById(Integer id) {
        return busRepository.findById(id);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }
}
