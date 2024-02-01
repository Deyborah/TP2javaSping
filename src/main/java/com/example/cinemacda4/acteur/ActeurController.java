package com.example.cinemacda4.acteur;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;

    private final ObjectMapper objectMapper;
    public ActeurController(
            ActeurService acteurService,
            ObjectMapper objectMapper
    ) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public Acteur save(@RequestBody Acteur entity) {
        return acteurService.save(entity);
    }

    @GetMapping("/{id}")
    public Acteur findById(@PathVariable Integer id) {
        return acteurService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody Acteur acteur) {
        acteurService.delete(acteur);
    }

    @GetMapping
    public List<Acteur> findAll() {
        return acteurService.findAll();
    }

    @GetMapping
    public List<ActeurSansFilmDto> findAlls() {
        return acteurService.findAll().stream().map(
                Acteur -> objectMapper.convertValue(Acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @GetMapping("/sansFilmsPar{id}") // /films/1
    public ActeurSansFilmDto findByIds(@PathVariable Integer id) {
        Acteur acteur = acteurService.findById(id);
        return objectMapper.convertValue(acteur , ActeurSansFilmDto.class);
    }

}

