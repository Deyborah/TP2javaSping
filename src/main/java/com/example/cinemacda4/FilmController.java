package com.example.cinemacda4;

import com.example.cinemacda4.acteur.ActeurSansFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.cinemacda4.acteur.Acteur;
import com.example.cinemacda4.realisateur.Realisateur;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    private final ObjectMapper objectMapper;

    public FilmController(
            FilmService filmService,
            ObjectMapper objectMapper
    ) {
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film save(@RequestBody Film film) {

        return filmService.save(film);
    }

    @GetMapping("/{id}") // /films/1
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);

        FilmCompletDto filmCompletDto = new FilmCompletDto();
        filmCompletDto.setId(film.getId());
        filmCompletDto.setDuree(film.getDuree());
        filmCompletDto.setSynopsis(film.getSynopsis());
        filmCompletDto.setRealisateur(film.getRealisateur());
        filmCompletDto.setDateSortie(film.getDateSortie());
        filmCompletDto.setActeurs(
                film.getActeurs().stream().map(
                        acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
                ).toList()
        );


        return filmCompletDto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @GetMapping("/search") // /film/search?titre=toto
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }

    @GetMapping("/{id}/acteurs")
    public List<ActeurSansFilmDto> findActeursByFilm(@PathVariable Integer id) {
        List<Acteur> acteurs = filmService.findActeursByFilm(id);

        return acteurs.stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @GetMapping("/{id}/realisateurs")
    public Realisateur findRealisateursByFilm(@PathVariable Integer id) {
        return filmService.findById(id).getRealisateur();
    }

    @PostMapping("/{id}/acteurs")
    public FilmCompletDto addActorToFilm(@PathVariable Integer id, @RequestBody Acteur acteur) {
        Film film = filmService.addActorToFilm(id, acteur);

        FilmCompletDto filmCompletDto = new FilmCompletDto();
        filmCompletDto.setId(film.getId());
        filmCompletDto.setDuree(film.getDuree());
        filmCompletDto.setRealisateur(film.getRealisateur());
        filmCompletDto.setDateSortie(film.getDateSortie());
        filmCompletDto.setSynopsis(film.getSynopsis());
        filmCompletDto.setActeurs(
                film.getActeurs().stream().map(
                        unmappedActor -> objectMapper.convertValue(
                                unmappedActor,
                                ActeurSansFilmDto.class

                        )
                ).toList()
        );

        return filmCompletDto;
    }
}