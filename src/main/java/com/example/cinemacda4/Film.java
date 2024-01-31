package com.example.cinemacda4;

import com.example.cinemacda4.acteur.Acteur;
import com.example.cinemacda4.realisateur.Realisateur;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "film")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)

//ne pas utiliser tjs @Data car trop lourd ici dto pas pb mais entité pas recommandé
public class Film {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dateDeSortie;

    @Column(nullable = false)
    private int duree;

    @Column(length = 500)
    private String synopsis;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="realisateur_id")
    private Realisateur realisteur;

    @ManyToMany
    @JoinTable(
            name= "acteur_film",
            joinColumns =@JoinColumn(name= "film_id"),
            inverseJoinColumns = @JoinColumn (name= "acteur_id")
    )

    private List<Acteur> acteur =new ArrayList<>();

}
