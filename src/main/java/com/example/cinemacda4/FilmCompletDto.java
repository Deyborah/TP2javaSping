package com.example.cinemacda4;

import com.example.cinemacda4.acteur.ActeurSansFilmDto;
import com.example.cinemacda4.realisateur.RealisateurDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
    public class FilmCompletDto {
        private Integer id;

        private String titre;

        private LocalDate dateSortie;

        private int duree;

        private String synopsis;

        private RealisateurDto realisateur;

        private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
    }

