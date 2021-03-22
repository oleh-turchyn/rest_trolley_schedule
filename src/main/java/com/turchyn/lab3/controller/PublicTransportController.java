package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.PublicTransportMapper;
import com.turchyn.lab3.model.PublicTransport;
import com.turchyn.lab3.model.dto.PublicTransportDto;
import com.turchyn.lab3.service.PublicTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/api")
public class PublicTransportController {
    private final PublicTransportService publicTransportService;

    @Autowired
    public PublicTransportController(PublicTransportService publicTransportService) {
        this.publicTransportService = publicTransportService;
    }

    @GetMapping("/transports")
    public ResponseEntity<List<PublicTransportDto>> findAll() {
        return ResponseEntity.ok(PublicTransportMapper.INSTANCE.transportToTransportDtos(publicTransportService.findAll()));
    }

    @PostMapping("/transports")
    public ResponseEntity<PublicTransportDto> create(@RequestBody PublicTransportDto publicTransportDto) {
        publicTransportService.save(PublicTransportMapper.INSTANCE.toPublicTransport(publicTransportDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(publicTransportDto);
    }

    @GetMapping(value = "/transportById/{id}")
    public ResponseEntity<PublicTransportDto> findById(@PathVariable int id) {
        Optional<PublicTransport> publicTransport = publicTransportService.findById(id);

        return ResponseEntity.ok(PublicTransportMapper.INSTANCE.toDto(publicTransport.get()));
    }

    @PutMapping("/transports/{id}")
    public ResponseEntity<PublicTransportDto> update(@PathVariable int id, @RequestBody PublicTransportDto publicTransportDto) {
        PublicTransport publicTransport = PublicTransportMapper.INSTANCE.toPublicTransport(publicTransportDto);
        publicTransport.setId(id);

        publicTransportService.save(publicTransport);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(publicTransportDto);
    }

    @DeleteMapping("/transports/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        publicTransportService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
