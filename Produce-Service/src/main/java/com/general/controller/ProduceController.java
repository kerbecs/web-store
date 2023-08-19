package com.general.controller;

import com.general.dto.ProduceDto;
import com.general.facade.ProduceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produces")
@RequiredArgsConstructor
@RefreshScope
public class ProduceController {
    private final ProduceFacade produceFacade;

    @GetMapping
    public ResponseEntity<List<ProduceDto>> getAllProduces() {
        return ResponseEntity.ok(produceFacade.getAllProduces());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProduceDto> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(produceFacade.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProduceDto>> getByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(produceFacade.getByName(name));
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<ProduceDto>> getByCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(produceFacade.getByCountry(country));
    }

    @PostMapping
    public ResponseEntity<ProduceDto> save(@RequestBody @Valid ProduceDto produceDto) {
        return new ResponseEntity<>(produceFacade.save(produceDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProduceDto> update(@RequestBody @Valid ProduceDto produceDto) {
        return new ResponseEntity<>(produceFacade.update(produceDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") String id) {
        produceFacade.deleteById(id);
    }
}
