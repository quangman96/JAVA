package com.codegym.repository;

import com.codegym.model.DataType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DataTypeRepository extends PagingAndSortingRepository<DataType,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE datatype SET isDeleted = 1 WHERE id_data_type = ?;", nativeQuery = true)
    void deletedDataType(@Param("id") Long id);
    @Query(value = "SELECT * FROM datatype WHERE isDeleted = 0;", nativeQuery = true)
    Iterable<DataType> findAllDataType();
}
