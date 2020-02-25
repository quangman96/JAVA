package com.codegym.service;

import com.codegym.model.Animals;
import org.springframework.stereotype.Service;

@Service
public interface AnimalsService {
    Iterable<Animals> findAll();

    Animals findById(Long id);

    void save(Animals animals);

    void remove(Long id);
}
