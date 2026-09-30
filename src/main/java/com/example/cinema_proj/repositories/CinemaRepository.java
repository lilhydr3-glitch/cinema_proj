package com.example.cinema_proj.repositories;

import com.example.cinema_proj.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cinemas", path = "cinemas")
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
