package com.codegym.service;

import com.codegym.model.Province;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    Iterable<Province>findAll();
    Province findId(Long id);
    void save(Province province);
    void delete(Long id);
    Iterable<Province> findAllProvince();
    void deletedProvince(@Param("id") Long id);
}
