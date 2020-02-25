package com.codegym.service;

import com.codegym.model.Species;
import org.springframework.stereotype.Service;

@Service
public interface SpeciesService {
    Iterable<Species> findAll();

    Species findById(Long id);

    void save(Species species);

    void remove(Long id);
}
