package com.codegym.cms.service;

import com.codegym.cms.model.Brand;

public interface BrandService {
    Iterable<Brand> findAll();

    Brand findById(int id);

    void save(Brand brand);

    void remove(int id);

//    void deleteAllByBrand_Id(Long id);
}
