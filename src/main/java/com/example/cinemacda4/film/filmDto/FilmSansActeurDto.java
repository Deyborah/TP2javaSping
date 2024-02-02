package com.example.cinemacda4.film.filmDto;

import com.example.cinemacda4.realisateur.Realisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmSansActeurDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private Realisateur realisateur;

}
