package com.codegym.cms.service.impl;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import com.codegym.cms.repository.ProductRepository;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove (long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByBrand(Brand brand) {
        return productRepository.findAllByBrand(brand);
    }
}
