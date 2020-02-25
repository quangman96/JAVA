package com.codegym.service.impl;

import com.codegym.model.Volunteer;
import com.codegym.repository.VolunteerRepository;
import com.codegym.service.VolunteerService;
import org.springframework.stereotype.Repository;

@Repository
public class VolunteerImpl implements VolunteerService {
    private VolunteerRepository volunteerRepository;

    @Override
    public Iterable<Volunteer> findAll() {
        return volunteerRepository.findAll();
    }

    @Override
    public Volunteer findById(Long id) {
        return volunteerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    @Override
    public void remove(Long id) {
        volunteerRepository.deleteById(id);
    }
}
