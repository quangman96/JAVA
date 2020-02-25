package com.codegym.service;

import com.codegym.model.Coach;
import org.springframework.stereotype.Service;

@Service
public interface CoachService {
    Iterable<Coach> findAll();

    Coach findById(Long id);

    void save(Coach coach);

    void remove(Long id);
}
