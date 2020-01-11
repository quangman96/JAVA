package com.codegym.cms.service;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Category;
import com.codegym.cms.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ProductService {
    Iterable<Product> findAll();

    Iterable<Product> findAllByBrand_Id(int id);

    Iterable<Product> findAllByCategory_Id(int id);

    Product findById(int id);

    void save(Product product);

    void sortDelete(int id);

    Iterable<Product> findAllByBrand(Brand brand);

    Iterable<Product> findAllByCategory(Category category);

    void upLoadFile(MultipartFile file) throws IOException;

}
