package com.example.cinemacda4.realisateur;

import com.example.cinemacda4.Film;
import com.example.cinemacda4.FilmRepository;
import com.example.cinemacda4.acteur.Acteur;
import com.example.cinemacda4.acteur.ActeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

        private final RealisateurService realisateurService;
    private final FilmRepository film;

    public RealisateurController(RealisateurService realisateurService, FilmRepository film) {
            this.realisateurService = realisateurService;
        this.film = film;
    }

        @GetMapping
        public List<Realisateur> findAll() {
            return realisateurService.findAll();
        }

        @PostMapping
        public Realisateur save(@RequestBody Realisateur realisateur) {
            return realisateurService.save(realisateur);
        }

        @GetMapping("/id")
        public Realisateur findById(Integer id) {
            return realisateurService.findById(id);
        }
        @DeleteMapping("/id")

        public void deleteById(@PathVariable Integer id) {
            realisateurService.deleteById(id);
        }

        @PutMapping
        public Realisateur update(Realisateur realisateur) {
            return realisateurService.update(realisateur);
        }

        @GetMapping("/search")
        public Realisateur findByFilm(@RequestParam String film) {
        return realisateurService.findByFilm(film);
    }


}
