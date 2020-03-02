package com.codegym.service.impl;

import com.codegym.model.Animals;
import com.codegym.repository.AnimalsRepository;
import com.codegym.service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalsImpl implements AnimalsService {
    @Autowired
    private AnimalsRepository animalsRepository;

    @Override
    public Iterable<Animals> findAll() {
        return animalsRepository.findAll();
    }

    @Override
    public Animals findById(Long id) {
        return animalsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Animals animals) {
        animalsRepository.save(animals);
    }

    @Override
    public void remove(Long id) {
        animalsRepository.deleteById(id);
    }
}
