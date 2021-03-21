package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.ScheduleMapper;
import com.turchyn.lab3.model.Schedule;
import com.turchyn.lab3.model.dto.ScheduleDto;
import com.turchyn.lab3.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class ScheduleController {
    ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleDto>> findAll() {
        return ResponseEntity.ok(ScheduleMapper.INSTANCE.scheduleToScheduleDtos(scheduleService.findAll()));
    }

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleDto> create(@RequestBody ScheduleDto ScheduleDto) {
        scheduleService.save(ScheduleMapper.INSTANCE.toSchedule(ScheduleDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(ScheduleDto);
    }

    @GetMapping(value = "/scheduleById/{id}")
    public ResponseEntity<ScheduleDto> findById(@PathVariable int id) {
        Optional<Schedule> schedule = scheduleService.findById(id);

        return ResponseEntity.ok(ScheduleMapper.INSTANCE.toDto(schedule.get()));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleDto> update(@PathVariable int id, @RequestBody ScheduleDto ScheduleDto) {
        Schedule schedule = ScheduleMapper.INSTANCE.toSchedule(ScheduleDto);
        schedule.setId(id);

        scheduleService.save(schedule);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ScheduleDto);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        scheduleService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
