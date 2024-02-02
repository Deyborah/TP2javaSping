package com.example.cinemacda4.realisateur;

import com.example.cinemacda4.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {


}
