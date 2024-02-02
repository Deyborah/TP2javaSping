package com.example.cinemacda4.sceance;

import com.example.cinemacda4.Film;
import com.example.cinemacda4.salle.Salle;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sceance {
    @Id
    @GeneratedValue
    private Integer id;

    private Date date;

    private Salle salle;

    private Film film;

    private Prix float;





}
