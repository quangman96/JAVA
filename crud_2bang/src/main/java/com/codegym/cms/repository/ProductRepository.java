package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAllByBrand(Brand brand);

}
