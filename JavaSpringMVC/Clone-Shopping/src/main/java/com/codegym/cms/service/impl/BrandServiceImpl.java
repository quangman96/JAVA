package com.codegym.cms.service.impl;

import com.codegym.cms.model.Brand;
import com.codegym.cms.repository.BrandRepository;
import com.codegym.cms.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }
    public Brand findById(int id) {
        return brandRepository.findById(id).orElse(null);
    }
    public void save(Brand brand){
        brandRepository.save(brand);
    }

    @Override
    public void remove(int id) {
        brandRepository.deleteById(id);
    }
//    @Override
//    public void deleteAllByBrand_Id(Long id) {
//        brandRepository.deleteAllByBrand_Id(id);
//    }
}
