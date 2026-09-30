package com.example.cinema_proj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCinema;

    private String nomCinema;

    private String adresse;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema")
    private List<Film> films = new ArrayList<>();

    public Cinema() {
    }

    public Cinema(Long idCinema, String nomCinema, String adresse, List<Film> films) {
        this.idCinema = idCinema;
        this.nomCinema = nomCinema;
        this.adresse = adresse;
        this.films = films;
    }

    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    public String getNomCinema() {
        return nomCinema;
    }

    public void setNomCinema(String nomCinema) {
        this.nomCinema = nomCinema;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
