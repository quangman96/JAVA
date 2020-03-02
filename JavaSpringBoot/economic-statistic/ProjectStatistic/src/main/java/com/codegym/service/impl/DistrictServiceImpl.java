package com.codegym.service.impl;

import com.codegym.model.District;
import com.codegym.repository.DistrictRepository;
import com.codegym.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public District findId(Long id) {
        return districtRepository.findById(id).orElse(null);
    }

    @Override
    public void save(District district) {
        districtRepository.save(district);
    }

    @Override
    public void delete(Long id) {
        districtRepository.deleteById(id);
    }

    @Override
    public Iterable<District> findAllDistrict() {
        return districtRepository.findAllDistrict();
    }

    @Override
    public void deletedDistrict(Long id) {
        districtRepository.deletedDistrict(id);
    }
}
