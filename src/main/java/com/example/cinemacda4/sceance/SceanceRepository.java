package com.example.cinemacda4.sceance;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceanceRepository {
    List<Sceance> findAll();

    Sceance save(Sceance sceance);
}
