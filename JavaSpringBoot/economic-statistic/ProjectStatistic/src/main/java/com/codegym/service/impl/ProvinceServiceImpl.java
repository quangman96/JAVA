package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ProvinceServiceImpl implements ProvinceService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    @Transactional
    public Iterable<Province> findAll() {
        TypedQuery<Province> query = em.createQuery("SELECT p FROM Province p WHERE p.isDeleted = 0",
                Province.class);
        return query.getResultList();
    }

    @Override
    public Province findId(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Iterable<Province> findAllProvince() {
        return provinceRepository.findAllProvince();
    }

    @Override
    public void deletedProvince(Long id) {
        provinceRepository.deletedProvince(id);
    }
}
