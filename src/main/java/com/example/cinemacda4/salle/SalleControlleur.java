package com.example.cinemacda4.salle;

import com.example.cinemacda4.Film;
import com.example.cinemacda4.FilmCompletDto;
import com.example.cinemacda4.FilmReduitDto;
import com.example.cinemacda4.acteur.Acteur;
import com.example.cinemacda4.acteur.ActeurSansFilmDto;
import com.example.cinemacda4.realisateur.Realisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleControlleur {

    private final SalleService salleService;
    private final ObjectMapper objectMapper;
    public SalleControlleur(SalleService salleService, ObjectMapper objectMapper) {
        this.salleService = salleService;
        this. objectMapper= objectMapper;
    }

    @GetMapping
    public List<Salle> findAll() {
        return salleService.findAll().stream().map(
                film -> objectMapper.convertValue(Salle, SalleService.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Salle save(@RequestBody Salle salle) {

        return salleService.save(salle);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        SalleService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return SalleService.update(film);
    }

    @GetMapping("/search")
    public Salle findAllBySalleNom(@RequestParam String nom) {

        return salleService.findAllBySalleNom(nom);
    }
    @GetMapping("/{id}") // /films/1
    public Salle findById(@PathVariable Integer id) {
        Salle salle = salleService.findById(id);

        SalleService salleS = new SalleService();
        salle.setId(salle.getId());
        salle.setNom(salle.getNom());
        salle.setNumero(salle.getNumero());
        salle.setCapacite(salle.getCapacite().stream()).map(
                unmappedSalle -> objectMapper.convertValue(
                        unmappedSalle,
                        SalleService.class).toList()
        );


        return salle;
    }


}
