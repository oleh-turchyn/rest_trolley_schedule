package com.turchyn.lab3.service.impl;

import com.turchyn.lab3.model.Schedule;
import com.turchyn.lab3.repository.ScheduleRepository;
import com.turchyn.lab3.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule save(Schedule object) {
        return scheduleRepository.save(object);
    }

    @Override
    public void removeById(Integer id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Optional<Schedule> findById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }
}
