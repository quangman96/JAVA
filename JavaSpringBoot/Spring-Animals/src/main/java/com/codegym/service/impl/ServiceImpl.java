package com.codegym.service.impl;

import com.codegym.model.Service;
import com.codegym.repository.ServiceRepository;
import com.codegym.service.ServiceService;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;

    @Override
    public Iterable<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
