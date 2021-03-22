package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.StopMapper;
import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.StopDto;
import com.turchyn.lab3.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class StopController {
    private final StopService stopService;

    @Autowired
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping("/stops")
    public ResponseEntity<List<StopDto>> findAll() {
        return ResponseEntity.ok(StopMapper.INSTANCE.stopToStopDtos(stopService.findAll()));
    }

    @PostMapping("/stops")
    public ResponseEntity<StopDto> create(@RequestBody StopDto StopDto) {
        stopService.save(StopMapper.INSTANCE.toStop(StopDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(StopDto);
    }

    @GetMapping(value = "/stopById/{id}")
    public ResponseEntity<StopDto> findById(@PathVariable int id) {
        Optional<Stop> stop = stopService.findById(id);

        return ResponseEntity.ok(StopMapper.INSTANCE.toDto(stop.get()));
    }

    @PutMapping("/stops/{id}")
    public ResponseEntity<StopDto> update(@PathVariable int id, @RequestBody StopDto StopDto) {
        Stop stop = StopMapper.INSTANCE.toStop(StopDto);
        stop.setId(id);

        stopService.save(stop);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(StopDto);
    }

    @DeleteMapping("/stops/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        stopService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
