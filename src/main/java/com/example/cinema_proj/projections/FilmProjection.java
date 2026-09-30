package com.example.cinema_proj.projections;

import com.example.cinema_proj.entities.Film;
import java.util.Date;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "filmProjection", types = Film.class)
public interface FilmProjection {

    Long getIdFilm();

    String getTitreFilm();

    Date getDateSortie();
}
