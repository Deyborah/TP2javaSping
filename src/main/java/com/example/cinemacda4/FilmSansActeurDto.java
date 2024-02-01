package com.example.cinemacda4;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmSansActeurDto {
    private Integer id;

    private String titre;

    private LocalDate dateSortie;

    private int duree;

    private List<FilmSansActeurDto> film = new ArrayList<>();

}
