package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.RouteMapper;
import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.dto.RouteDto;
import com.turchyn.lab3.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class RouteController {
    RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ResponseEntity<List<RouteDto>> findAll() {
        return ResponseEntity.ok(RouteMapper.INSTANCE.routeToRouteDtos(routeService.findAll()));
    }

    @PostMapping("/routes")
    public ResponseEntity<RouteDto> create(@RequestBody RouteDto RouteDto) {
        routeService.save(RouteMapper.INSTANCE.toRoute(RouteDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(RouteDto);
    }

    @GetMapping(value = "/routeById/{id}")
    public ResponseEntity<RouteDto> findById(@PathVariable int id) {
        Optional<Route> route = routeService.findById(id);

        return ResponseEntity.ok(RouteMapper.INSTANCE.toDto(route.get()));
    }

    @PutMapping("/routes/{id}")
    public ResponseEntity<RouteDto> update(@PathVariable int id, @RequestBody RouteDto RouteDto) {
        Route route = RouteMapper.INSTANCE.toRoute(RouteDto);
        route.setId(id);

        routeService.save(route);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(RouteDto);
    }

    @DeleteMapping("/routes/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        routeService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
