package com.example.cinemacda4.acteur;

import com.example.cinemacda4.realisateur.Realisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/acteur")
public class ActeurController {

        private final ActeurService acteurService;

        public ActeurController(ActeurService acteurService) {
            this.acteurService = acteurService;
        }

        @GetMapping
        public List<Acteur> findAll() {
            return acteurService.findAll();
        }

        @PostMapping
        public Acteur save(@RequestBody Acteur acteur) {
            return acteurService.save(acteur);
        }

        @GetMapping("/id")
        public Acteur findById(Integer id) {
            return acteurService.findById(id);
        }
        @DeleteMapping("/id")

        public void deleteById(@PathVariable Integer id) {
            acteurService.deleteById(id);
        }

        @PutMapping
        public Acteur update(Acteur acteur) {
            return acteurService.update(acteur);
        }

    @GetMapping("/search")
    public Acteur findByFilm(@RequestParam String film) {
        return acteurService.findByFilm(film);
    }

}

