package com.example.cinemacda4.sceance;

import com.example.cinemacda4.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SceanceRepository extends JpaRepository<Sceance, Integer> {


    Optional<List<Film>> findAllBySceanceid(Integer id);
}
