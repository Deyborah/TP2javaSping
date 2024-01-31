package com.example.cinemacda4.realisateur;

import com.example.cinemacda4.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
    Optional<Realisateur> findByFilm(String film);


}
