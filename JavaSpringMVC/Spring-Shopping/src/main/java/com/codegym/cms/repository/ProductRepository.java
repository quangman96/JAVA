package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    Iterable<Product> findAllByBrand(Brand brand);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);

}
