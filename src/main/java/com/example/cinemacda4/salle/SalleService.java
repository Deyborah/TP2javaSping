package com.example.cinemacda4.salle;

import com.example.cinemacda4.BadRequestException;
import com.example.cinemacda4.Film;
import com.example.cinemacda4.FilmNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


public class SalleService {

    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {

        this.salleRepository = salleRepository;
    }

    public List<Salle> findAll() {

        return salleRepository.findAll();
    }
    public Salle save(Salle salle) throws BadRequestException {
        verifySalle(salle);

        return salleRepository.save(salle);
    }

    private void verifySalle(Salle salle) {
    }

    public Salle findById(Integer id) {
        return salleRepository.findById(id)
                .orElseThrow(
                        () -> new FilmNotFoundException(id)
                );
    }

    public void deleteById(Integer id) {
        Salle salle = this.findById(id);
        salleRepository.delete(salle);
    }

    public Salle update(Salle salle) {

        return salleRepository.save(salle);
    }

    public Salle findAllBySalleNom(String nom) {
        return salleRepository.findAllBySalleNom(nom)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun salle ayant ce nom"
                ));
    }

}
