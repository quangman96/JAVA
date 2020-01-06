package com.codegym.cms.service.impl;

import com.codegym.cms.model.Brand;
import com.codegym.cms.repository.BrandRepository;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id){
        return brandRepository.findById(id).get();
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void remove(Long id) {
        brandRepository.deleteById(id);
    }
}
