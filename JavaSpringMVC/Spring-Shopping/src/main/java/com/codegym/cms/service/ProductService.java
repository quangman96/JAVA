package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;


public interface ProductService {
    Iterable<Product> findAll();

    Iterable<Product> findAllByBrand_Id(int id);

    Product findById(int id);

    void save(Product product);

    void sortDelete(int id);

    Iterable<Product> findAllByBrand(Brand brand);

}
