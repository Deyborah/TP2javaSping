package com.example.cinemacda4.sceance;

import com.example.cinemacda4.BadRequestException;
import com.example.cinemacda4.film.FilmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SceanceService {
    private final SceanceRepository sceanceRepository;

    public SceanceService(SceanceRepository sceanceRepository) {

        this.sceanceRepository = sceanceRepository;
    }

    //liste des sceances
    public List<Sceance> findAll() {

        return sceanceRepository.findAll();
    }
    //sauvegarde données de sceance
    public Sceance save(Sceance sceance) throws BadRequestException {
        verifySceance(sceance);

        return sceanceRepository.save(sceance);
    }

    private void verifySceance(Sceance sceance) {
    }

    //chercher les sceances via id
    public Sceance findById(Integer id) {
        return sceanceRepository.findById(id)
                .orElseThrow(
                        () -> new FilmNotFoundException(id)
                );
    }

    //supprimer sceance par l'id
    public void deleteById(Integer id) {
        Sceance sceance = this.findById(id);
        sceanceRepository.delete(sceance);
    }

    public Sceance update(Sceance sceance) {

        return sceanceRepository.save(sceance);
    }

    public Sceance findAllByPlace(int place) {
        return (Sceance) sceanceRepository.findAllBySceanceid(place)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "cette sceance n'as pas de place définit"
                ));
    }

}

