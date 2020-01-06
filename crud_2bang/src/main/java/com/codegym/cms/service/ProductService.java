package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void remove(long id);

    Iterable<Product> findAllByBrand(Brand brand);

}
