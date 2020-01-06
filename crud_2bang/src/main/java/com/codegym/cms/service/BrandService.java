package com.codegym.cms.service;

import com.codegym.cms.model.Brand;

public interface BrandService {
    Iterable<Brand> findAll();

    Brand findById(Long id);

    void save(Brand brand);

    void remove(Long id);
}
