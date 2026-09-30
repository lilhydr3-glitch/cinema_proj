package com.example.cinema_proj.services;

import com.example.cinema_proj.entities.Cinema;
import com.example.cinema_proj.repositories.CinemaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Cinema save(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Optional<Cinema> findById(Long idCinema) {
        return cinemaRepository.findById(idCinema);
    }

    @Override
    public Optional<Cinema> update(Long idCinema, Cinema cinema) {
        return cinemaRepository.findById(idCinema).map(existingCinema -> {
            existingCinema.setNomCinema(cinema.getNomCinema());
            existingCinema.setAdresse(cinema.getAdresse());
            return cinemaRepository.save(existingCinema);
        });
    }

    @Override
    public boolean deleteById(Long idCinema) {
        if (!cinemaRepository.existsById(idCinema)) {
            return false;
        }
        cinemaRepository.deleteById(idCinema);
        return true;
    }
}
