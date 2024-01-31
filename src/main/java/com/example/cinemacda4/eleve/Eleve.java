package com.example.cinemacda4.eleve;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Eleve {
    @Id
    @GeneratedValue
    private Integer Id;

    @OneToOne
    private carnetDeNotes carnetDeNotes;

}
