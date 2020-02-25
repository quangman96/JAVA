package com.codegym.service.impl;

import com.codegym.model.Species;
import com.codegym.repository.SpeciesRepository;
import com.codegym.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpeciesImpl implements SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    @Override
    public Iterable<Species> findAll() {
        return speciesRepository.findAll();
    }

    @Override
    public Species findById(Long id) {
        return speciesRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Species species) {
        speciesRepository.save(species);
    }

    @Override
    public void remove(Long id) {
        speciesRepository.deleteById(id);
    }
}
