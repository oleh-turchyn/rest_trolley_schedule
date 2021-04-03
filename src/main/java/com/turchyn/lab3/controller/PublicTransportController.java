package com.turchyn.lab3.controller;

import com.turchyn.lab3.mapper.postmapper.PostTransportMapper;
import com.turchyn.lab3.model.PublicTransport;
import com.turchyn.lab3.model.dto.postdto.PostTransportDto;
import com.turchyn.lab3.model.dto.postdto.PostStopDto;
import com.turchyn.lab3.service.PublicTransportService;
import com.turchyn.lab3.util.PublicTransportUtil;
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
public class PublicTransportController {
    PublicTransportService publicTransportService;
    PublicTransportUtil publicTransportUtil;

    @Autowired
    public PublicTransportController(PublicTransportService publicTransportService, PublicTransportUtil publicTransportUtil) {
        this.publicTransportService = publicTransportService;
        this.publicTransportUtil = publicTransportUtil;
    }

    @GetMapping("/transports")
    public ResponseEntity<List<PostTransportDto>> findAll() {
        return ResponseEntity.ok(PostTransportMapper.INSTANCE.transportToPostTransportDtos(publicTransportService.findAll()));
    }

    @PostMapping("/transports")
    public ResponseEntity<PostTransportDto> create(@RequestBody PostTransportDto postTransportDto) {
        publicTransportService.save(PostTransportMapper.INSTANCE.toPublicTransport(postTransportDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(postTransportDto);
    }

    @GetMapping(value = "/transportById/{id}")
    public ResponseEntity<PostTransportDto> findById(@PathVariable int id) {
        Optional<PublicTransport> publicTransport = publicTransportService.findById(id);

        return ResponseEntity.ok(PostTransportMapper.INSTANCE.toDto(publicTransport.get()));
    }

    @PutMapping("/transports/{id}")
    public ResponseEntity<PostTransportDto> update(@PathVariable int id, @RequestBody PostTransportDto postTransportDto) {
        PublicTransport publicTransport = PostTransportMapper.INSTANCE.toPublicTransport(postTransportDto);
        publicTransport.setId(id);

        publicTransportService.save(publicTransport);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postTransportDto);
    }

    @DeleteMapping("/transports/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        publicTransportService.removeById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/getStopsByTransportId/{id}")
    public ResponseEntity<Set<PostStopDto>> getStopsByTransportId(@PathVariable int id) {
        return ResponseEntity.ok(publicTransportUtil.getStopsByTransportId(id));
    }
}
