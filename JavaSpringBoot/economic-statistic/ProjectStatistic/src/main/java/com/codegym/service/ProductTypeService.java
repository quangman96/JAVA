package com.codegym.service;

import com.codegym.model.ProductType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ProductTypeService {
    Iterable<ProductType>findAll();
    ProductType findId(Long id);
    void save(ProductType productType);
    void delete(Long id);
    void deletedProductType(@Param("id") Long id);
    Iterable<ProductType> findAllProductType();
}
