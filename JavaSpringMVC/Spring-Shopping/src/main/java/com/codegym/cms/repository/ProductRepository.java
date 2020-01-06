package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
    Iterable<Product> findAllByBrand(Brand brand);
    Iterable<Product> findAllByBrand_Id(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.isDelete = 1 WHERE p.id= :id")
    void sortDelete(@Param("id") int id);
}
