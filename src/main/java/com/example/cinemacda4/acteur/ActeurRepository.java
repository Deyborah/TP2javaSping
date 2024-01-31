package com.example.cinemacda4.acteur;

import com.example.cinemacda4.realisateur.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    Optional<Acteur> findByFilm(String film);

}
