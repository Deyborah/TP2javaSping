package com.example.cinemacda4.salle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SalleRepository extends JpaRepository<Salle, Integer> {

    Optional <Salle> findAllBySalleNom(String nom);
}
