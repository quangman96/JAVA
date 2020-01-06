package com.codegym.cms.service;

import com.codegym.cms.model.Brand;

public interface BrandService {
    Iterable<Brand> findAll();

    Brand findById(int id);

    void save(Brand brand);

    void sortDelete(int id);

}
