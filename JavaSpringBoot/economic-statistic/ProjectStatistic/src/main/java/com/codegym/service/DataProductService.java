package com.codegym.service;

import com.codegym.model.DataProduct;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface DataProductService {
    Iterable<DataProduct> findAllDataProduct();
    void deletedDataProduct(@Param("id") Long id);
    Iterable<DataProduct>findAll();
    DataProduct findId(Long id);
    void save(DataProduct dataProduct);
    void delete(Long id);
}
