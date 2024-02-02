package com.example.cinemacda4.film.filmDto;

import lombok.Data;

import java.time.LocalDate;

@Data
    public class FilmReduitDto {
        private Integer id;

        private String titre;

        private LocalDate dateSortie;

        private int duree;
    }
