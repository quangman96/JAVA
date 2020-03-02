package com.codegym.repository;

import com.codegym.model.ProductType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE producttype SET is_deleted = 1 WHERE id_product_type = ?;", nativeQuery = true)
    void deletedProductType(@Param("id") Long id);
    @Query(value = "SELECT * FROM producttype WHERE is_deleted = 0;", nativeQuery = true)
    Iterable<ProductType> findAllProductType();
}
