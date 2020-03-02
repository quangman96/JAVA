package com.codegym.repository;

import com.codegym.model.DataProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DataProductRepository extends PagingAndSortingRepository<DataProduct,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE dataproduct SET is_deleted = 1 WHERE id_data = ?;", nativeQuery = true)
    void deletedDataProduct(@Param("id") Long id);
    @Query(value = "SELECT * FROM dataproduct WHERE is_deleted= 0;", nativeQuery = true)
    Iterable<DataProduct> findAllDataProduct();
}
