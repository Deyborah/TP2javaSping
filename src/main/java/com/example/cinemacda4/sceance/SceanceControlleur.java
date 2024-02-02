package com.example.cinemacda4.sceance;

import com.example.cinemacda4.film.Film;
import com.example.cinemacda4.film.FilmService;
import com.example.cinemacda4.film.filmDto.FilmReduitDto;
import com.example.cinemacda4.salle.Salle;
import com.example.cinemacda4.salle.SalleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sceance")
public class SceanceControlleur {
    private final SceanceService sceanceService;

    private final ObjectMapper objectMapper;

    public SceanceControlleur(SceanceService sceanceService, ObjectMapper objectMapper) {
        this.sceanceService = sceanceService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Sceance> findAll() {
        return sceanceService.findAll().stream().map(
                sceance -> objectMapper.convertValue(sceance, Sceance.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sceance save(@RequestBody Sceance sceance) {

        return sceanceService.save(sceance);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {

        sceanceService.deleteById(id);
    }

    @PutMapping
    public Sceance update(@RequestBody Sceance sceance) {

        return sceanceService.update(sceance);
    }

    @GetMapping("/search")
    public Sceance findAllByPlace(@RequestParam int place) {

        return sceanceService.findAllByPlace(place);
    }
    @GetMapping("/{id}") // /films/1
    public Sceance findById(@PathVariable Integer id) {
        Sceance sceance = sceanceService.findById(id);

        sceance = new SceanceService();
        sceance.setId(sceance.getId());
        sceance.setDate(sceance.getDate());
        sceance.setPrix(sceance.getPrix().stream().map(
                unmappedService -> objectMapper.convertValue(
                        unmappedService SalleService.class).toList()
        );


        return sceance;
    }


}


