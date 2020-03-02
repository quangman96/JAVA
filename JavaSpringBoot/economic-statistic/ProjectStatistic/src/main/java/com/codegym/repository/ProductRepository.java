package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET is_deleted = 1 WHERE id_product = ?;", nativeQuery = true)
    void deletedProduct(@Param("id") Long id);
    @Query(value = "SELECT * FROM product WHERE is_deleted = 0;", nativeQuery = true)
    Iterable<Product> findAllProduct();
}
