package com.codegym.service;

import com.codegym.model.Service;

@org.springframework.stereotype.Service
public interface ServiceService {
    Iterable<Service> findAll();

    Service findById(Long id);

    void save(Service service);

    void remove(Long id);
}
