package com.example.cinemacda4.film.filmDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmSansActeursNiRealisateurDto {
    private String titre;
    private int duree;
    private LocalDate dateSortie;
}