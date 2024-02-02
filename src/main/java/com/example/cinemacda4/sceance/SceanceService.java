package com.example.cinemacda4.sceance;

import com.example.cinemacda4.BadRequestException;
import com.example.cinemacda4.film.FilmNotFoundException;
import com.example.cinemacda4.sceance
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SceanceService {
    private final SceanceRepository sceanceRepository;

    public SceanceService(SceanceRepository sceanceRepository) {

        this.sceanceRepository = sceanceRepository;
    }

    public List<Sceance> findAll() {

        return sceanceRepository.findAll();
    }
    public Sceance save(Sceance sceance) throws BadRequestException {
        verifySceance(sceance);

        return sceanceRepository.save(sceance);
    }

    private void verifySceance(Sceance sceance) {
    }
    public Sceance findById(Integer id) {
        return sceanceRepository.findById(id)
                .orElseThrow(
                        () -> new FilmNotFoundException(id)
                );
    }

    public void deleteById(Integer id) {
        Sceance salle = this.findById(id);
        sceanceRepository.delete(salle);
    }

    public Sceance update(Sceance sceance) {

        return sceanceRepository.save(sceance);
    }

    public Sceance findAllBySceanceid(String nom) {
        return sceanceRepository.findAllBySceanceid(nom)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun salle ayant ce nom"
                ));
    }

}

}
