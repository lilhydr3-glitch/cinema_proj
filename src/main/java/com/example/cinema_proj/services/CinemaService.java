package com.example.cinema_proj.services;

import com.example.cinema_proj.entities.Cinema;
import java.util.List;
import java.util.Optional;

public interface CinemaService {

    Cinema save(Cinema cinema);

    List<Cinema> findAll();

    Optional<Cinema> findById(Long idCinema);

    Optional<Cinema> update(Long idCinema, Cinema cinema);

    boolean deleteById(Long idCinema);
}
