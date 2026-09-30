package com.example.cinema_proj.controllers;

import com.example.cinema_proj.entities.Cinema;
import com.example.cinema_proj.services.CinemaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinemas")
@CrossOrigin
public class CinemaRestController {

    private final CinemaService cinemaService;

    public CinemaRestController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<Cinema> findAll() {
        return cinemaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> findById(@PathVariable Long id) {
        return cinemaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cinema> create(@RequestBody Cinema cinema) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cinemaService.save(cinema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cinema> update(@PathVariable Long id, @RequestBody Cinema cinema) {
        return cinemaService.update(id, cinema)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!cinemaService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
