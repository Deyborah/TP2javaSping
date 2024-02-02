package com.example.cinemacda4.realisateur;

import com.example.cinemacda4.film.filmDto.FilmMiniDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

    @Data
    public class RealisateurAvecFilmsDto {
        private Integer id;
        private String nom;
        private String prenom;
        private List<FilmMiniDto> films = new ArrayList<>();
    }

