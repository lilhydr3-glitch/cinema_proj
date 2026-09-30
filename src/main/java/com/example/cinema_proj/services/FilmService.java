package com.example.cinema_proj.services;

import com.example.cinema_proj.entities.Cinema;
import com.example.cinema_proj.entities.Film;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FilmService {

    Film save(Film film);

    List<Film> findAll();

    Optional<Film> findById(Long idFilm);

    Optional<Film> update(Long idFilm, Film film);

    boolean deleteById(Long idFilm);

    List<Film> findByTitreFilm(String titreFilm);

    List<Film> findByTitreFilmContains(String texte);

    List<Film> findByCinema(Cinema cinema);

    List<Film> findByCinemaIdCinema(Long idCinema);

    List<Film> findAllSorted();

    List<Film> findFilmsReleasedOnOrAfter(Date date);
}
