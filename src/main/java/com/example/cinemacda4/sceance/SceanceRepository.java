package com.example.cinemacda4.sceance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SceanceRepository extends JpaRepository<Sceance, Integer> {


    Optional<List<Sceance>> findAllBySceanceid(Integer id);

    Optional<List<Sceance>>  findAllByPlace(int place);
}
