package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void remove(int id);

    Iterable<Product> findAllByBrand(Brand brand);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);


}
