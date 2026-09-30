package com.example.cinema_proj.repositories;

import com.example.cinema_proj.entities.Cinema;
import com.example.cinema_proj.entities.Film;
import com.example.cinema_proj.projections.FilmProjection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        collectionResourceRel = "films",
        path = "films",
        excerptProjection = FilmProjection.class)
public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByTitreFilm(String titreFilm);

    List<Film> findByTitreFilmContains(String texte);

    List<Film> findByCinema(Cinema cinema);

    List<Film> findByCinema_IdCinema(Long idCinema);

    List<Film> findAllByOrderByTitreFilmAsc();

    @Query("select f from Film f where f.dateSortie >= :date order by f.dateSortie")
    List<Film> findFilmsReleasedOnOrAfter(@Param("date") Date date);
}
