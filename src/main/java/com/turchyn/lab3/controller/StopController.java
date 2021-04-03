package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.StopMapper;
import com.turchyn.lab3.model.Stop;
import com.turchyn.lab3.model.dto.StopDto;
import com.turchyn.lab3.model.dto.postdto.PostRouteDto;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.service.StopService;
import com.turchyn.lab3.util.StopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class StopController {
    StopService stopService;
    StopUtil stopUtil;

    @Autowired
    public StopController(StopService stopService, StopUtil stopUtil) {
        this.stopService = stopService;
        this.stopUtil = stopUtil;
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
    public ResponseEntity<StopDto> delete(@PathVariable int id) {
        stopService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/getRoutesByStopName/{name}")
    public ResponseEntity<Set<PostRouteDto>> getRoutesByStopName(@PathVariable String name) {
        return ResponseEntity.ok(stopUtil.getRoutesByStopName(name));
    }

    @GetMapping("/getTransportByStopName/{name}")
    public ResponseEntity<Set<PostTransportDto>> getTransportByStopName(@PathVariable String name) {
        return ResponseEntity.ok(stopUtil.getTransportByStopName(name));
    }
}
