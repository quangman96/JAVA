package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Category;
import com.codegym.cms.model.Product;


public interface ProductService {
    Iterable<Product> findAll();

    Iterable<Product> findAllByBrand_Id(int id);

    Iterable<Product> findAllByCategory_Id(int id);

    Product findById(int id);

    void save(Product product);

    void sortDelete(int id);

    Iterable<Product> findAllByBrand(Brand brand);

    Iterable<Product> findAllByCategory(Category category);

}
