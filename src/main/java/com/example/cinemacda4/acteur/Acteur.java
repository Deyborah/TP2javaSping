package com.example.cinemacda4.acteur;


import com.example.cinemacda4.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Acteur {

    @Id
    @GeneratedValue
    private Integer id;

    private String nom;
    private String prenom;

    @ManyToMany(
            mappedBy = "acteurs",
            cascade = CascadeType.PERSIST

    )
    private List<Film> films = new ArrayList<>();


}
