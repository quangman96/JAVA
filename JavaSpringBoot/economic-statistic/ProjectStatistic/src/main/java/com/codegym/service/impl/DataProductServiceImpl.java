package com.codegym.service.impl;

import com.codegym.model.DataProduct;
import com.codegym.repository.DataProductRepository;
import com.codegym.service.DataProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProductServiceImpl implements DataProductService {
    @Autowired
    private DataProductRepository dataProductRepository;
    @Override
    public Iterable<DataProduct> findAllDataProduct() {
        return dataProductRepository.findAllDataProduct();
    }

    @Override
    public void deletedDataProduct(Long id) {
dataProductRepository.deletedDataProduct(id);
    }

    @Override
    public Iterable<DataProduct> findAll() {
        return dataProductRepository.findAll();
    }

    @Override
    public DataProduct findId(Long id) {
        return dataProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DataProduct dataProduct) {
dataProductRepository.save(dataProduct);
    }

    @Override
    public void delete(Long id) {
dataProductRepository.deleteById(id);
    }
}
