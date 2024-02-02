package com.example.cinemacda4.film.filmDto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class FilmMiniDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
}