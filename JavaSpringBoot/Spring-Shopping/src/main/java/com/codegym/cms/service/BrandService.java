package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    Iterable<Brand> findAll();

    Brand findById(Long id);

    void save(Brand brand);

    void sortDelete(Long id);

}
