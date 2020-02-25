package com.codegym.service;

import com.codegym.model.Volunteer;
import org.springframework.stereotype.Service;

@Service
public interface VolunteerService {
    Iterable<Volunteer> findAll();

    Volunteer findById(Long id);

    void save(Volunteer volunteer);

    void remove(Long id);
}
