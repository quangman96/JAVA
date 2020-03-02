package com.codegym.service.impl;

import com.codegym.model.ProductType;
import com.codegym.repository.ProductTypeRepository;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public Iterable<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findId(Long id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

    @Override
    public void deletedProductType(Long id) {
        productTypeRepository.deletedProductType(id);
    }

    @Override
    public Iterable<ProductType> findAllProductType() {
        return productTypeRepository.findAllProductType();
    }
}
