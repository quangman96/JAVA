package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Iterable<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public Product findId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ArrayList<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deletedProduct(Long id) {
        productRepository.deletedProduct(id);
    }

    @Override
    public Iterable<Product> findALl() {
        return productRepository.findAll();
    }
}
