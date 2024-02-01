package com.example.cinemacda4.acteur;

import lombok.Data;

import java.util.List;

@Data
public class ActeurReduitDto {
    private Integer id;

    private String nom;

    private String prenom;

    public void setFilms(List<Object> list) {
    }
}
