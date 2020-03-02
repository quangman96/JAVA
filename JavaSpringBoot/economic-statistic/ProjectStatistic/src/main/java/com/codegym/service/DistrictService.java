package com.codegym.service;

import com.codegym.model.District;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface DistrictService {
    Iterable<District>findAll();
    District findId(Long id);
    void save(District district);
    void delete(Long id);
    Iterable<District> findAllDistrict();
    void deletedDistrict(@Param("id") Long id);
}
