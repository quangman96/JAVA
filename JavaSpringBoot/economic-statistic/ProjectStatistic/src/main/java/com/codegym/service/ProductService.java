package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ProductService {
    Iterable<Product> findAllProduct();
    Product findId(Long id);
    void save(ArrayList<Product> products);
    void save(Product product);
    void delete(Long id);
    void deletedProduct(@Param("id") Long id);
    Iterable<Product> findALl();

}
