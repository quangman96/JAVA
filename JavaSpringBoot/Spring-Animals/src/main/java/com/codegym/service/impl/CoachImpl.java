package com.codegym.service.impl;

import com.codegym.model.Coach;
import com.codegym.repository.CoachRepository;
import com.codegym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CoachImpl implements CoachService {
    @Autowired
    private CoachRepository coachRepository;

    @Override
    public Iterable<Coach> findAll() { return coachRepository.findAll();
    }

    @Override
    public Coach findById(Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public void remove(Long id) {
        coachRepository.deleteById(id);
    }
}
