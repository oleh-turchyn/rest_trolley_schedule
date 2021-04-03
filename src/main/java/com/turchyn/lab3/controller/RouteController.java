package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.RouteMapper;
import com.turchyn.lab3.model.Route;
import com.turchyn.lab3.model.dto.RouteDto;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.service.RouteService;
import com.turchyn.lab3.util.RouteUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class RouteController {
    RouteService routeService;
    RouteUtil routeUtil;

    public RouteController(RouteService routeService, RouteUtil routeUtil) {
        this.routeService = routeService;
        this.routeUtil = routeUtil;
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

    @GetMapping("/getStopsByRouteName/{name}")
    public ResponseEntity<Set<PostStopDto>> getStopsByTransportId(@PathVariable String name) {
        return ResponseEntity.ok(routeUtil.getStopsByRouteName(name));
    }

    @GetMapping("/getTransportsByRouteNumber/{number}")
    public ResponseEntity<Set<PostTransportDto>> getTransportsByRouteNumber(@PathVariable int number) {
        return ResponseEntity.ok(routeUtil.getTransportsByRouteNumber(number));
    }

}
