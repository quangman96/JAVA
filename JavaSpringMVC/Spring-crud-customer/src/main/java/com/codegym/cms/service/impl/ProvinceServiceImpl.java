package com.codegym.cms.service.impl;

import com.codegym.cms.model.Province;
import com.codegym.cms.repository.ProvinceRepository;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id);
    }
    @Override
    public void save(Province model) {
        provinceRepository.save(model);
    }
    @Override
    public void remove(Long id) {
        provinceRepository.remove(id);
    }
}
