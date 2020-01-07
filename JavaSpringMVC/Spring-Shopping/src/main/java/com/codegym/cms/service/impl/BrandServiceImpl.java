package com.codegym.cms.service.impl;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import com.codegym.cms.repository.BrandRepository;
import com.codegym.cms.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class BrandServiceImpl implements BrandService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    @Transactional
    public Iterable<Brand> findAll() {
        TypedQuery<Brand> query = em.createQuery("SELECT b FROM Brand b WHERE b.isDelete = 0",
                Brand.class);
        return query.getResultList();
    }
    public Brand findById(int id) {
        return brandRepository.findById(id).orElse(null);
    }
    public void save(Brand brand){
        brandRepository.save(brand);
    }

    @Override
    public void sortDelete(int id) {
        brandRepository.sortDelete(id);
    }

}
