package com.example.cinemacda4.eleve;

import java.util.List;

public class EleveService {
        private final EleveRepository eleveRepository;

        public EleveService(EleveRepository eleveRepository) {
            this.eleveRepository = eleveRepository;
        }

        public List<Eleve> findAll() {
            return eleveRepository.findAll();
        }

        public Eleve save(Eleve eleve) {
            return eleveRepository.save(eleve);
        }
}
