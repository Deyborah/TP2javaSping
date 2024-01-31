package com.example.cinemacda4;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitre(String Titre);

    Optional<Film> findByDateSortieAfter(LocalDate date);
}
