package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Category;
import com.codegym.cms.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.isDelete = 1 WHERE p.id = :id")
    void sortDelete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("SELECT p FROM Product p WHERE (p.category.id = :id1 AND p.brand.id = :id2 AND p.isDelete = 0)")
    Iterable<Product> findAllByCategoryAndBrand(@Param("id1") Long id1, @Param("id2") Long id2);

    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllByBrand(Brand brand);

    Iterable<Product> findAllByBrand_Id(Long id);

    Iterable<Product> findAllByCategory_Id(Long id);

}


