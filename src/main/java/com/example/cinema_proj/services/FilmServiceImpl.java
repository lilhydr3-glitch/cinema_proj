package com.example.cinema_proj.services;

import com.example.cinema_proj.entities.Cinema;
import com.example.cinema_proj.entities.Film;
import com.example.cinema_proj.repositories.CinemaRepository;
import com.example.cinema_proj.repositories.FilmRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final CinemaRepository cinemaRepository;

    public FilmServiceImpl(FilmRepository filmRepository, CinemaRepository cinemaRepository) {
        this.filmRepository = filmRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Film save(Film film) {
        setExistingCinema(film);
        return filmRepository.save(film);
    }

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<Film> findById(Long idFilm) {
        return filmRepository.findById(idFilm);
    }

    @Override
    public Optional<Film> update(Long idFilm, Film film) {
        return filmRepository.findById(idFilm).map(existingFilm -> {
            existingFilm.setTitreFilm(film.getTitreFilm());
            existingFilm.setDateSortie(film.getDateSortie());
            existingFilm.setCinema(film.getCinema());
            setExistingCinema(existingFilm);
            return filmRepository.save(existingFilm);
        });
    }

    @Override
    public boolean deleteById(Long idFilm) {
        if (!filmRepository.existsById(idFilm)) {
            return false;
        }
        filmRepository.deleteById(idFilm);
        return true;
    }

    @Override
    public List<Film> findByTitreFilm(String titreFilm) {
        return filmRepository.findByTitreFilm(titreFilm);
    }

    @Override
    public List<Film> findByTitreFilmContains(String texte) {
        return filmRepository.findByTitreFilmContains(texte);
    }

    @Override
    public List<Film> findByCinema(Cinema cinema) {
        return filmRepository.findByCinema(cinema);
    }

    @Override
    public List<Film> findByCinemaIdCinema(Long idCinema) {
        return filmRepository.findByCinema_IdCinema(idCinema);
    }

    @Override
    public List<Film> findAllSorted() {
        return filmRepository.findAllByOrderByTitreFilmAsc();
    }

    @Override
    public List<Film> findFilmsReleasedOnOrAfter(Date date) {
        return filmRepository.findFilmsReleasedOnOrAfter(date);
    }

    private void setExistingCinema(Film film) {
        Cinema cinema = film.getCinema();
        if (cinema == null || cinema.getIdCinema() == null) {
            return;
        }
        Cinema existingCinema = cinemaRepository.findById(cinema.getIdCinema())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cinema not found: " + cinema.getIdCinema()));
        film.setCinema(existingCinema);
    }
}
