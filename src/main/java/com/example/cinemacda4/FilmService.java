package com.example.cinemacda4;

import com.example.cinemacda4.acteur.Acteur;
import com.example.cinemacda4.acteur.ActeurRepository;
import com.example.cinemacda4.acteur.ActeurService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Film Non trouvé"
                        )
                );
    }

    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }

    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le titre : " + titre
                        )
                );
    }

    public List<Film> findAllByRealisateurId(Integer id) {
        return filmRepository.findAllByRealisateurId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucun film ayant ce réalisateur"
                ));
    }

    public List<Acteur> findActeursByFilm(Integer id) {
        Film film = this.findById(id);
        return film.getActeurs();
    }
    private ActeurService acteurService;

    public FilmService(){
        acteurService = new acteurService();
    }
    public FilmService findById(@PathVariable Integer id){
    return findById(id).acteurService;
    }


    public Film save(FilmService entity) {

        return FilmService.save(entity);
    }
}