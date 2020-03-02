package com.codegym.repository;

import com.codegym.model.Province;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE province SET is_deleted = 1 WHERE id_province = ?;", nativeQuery = true)
    void deletedProvince(@Param("id") Long id);
    @Query(value = "SELECT * FROM province WHERE is_deleted = 0;", nativeQuery = true)
    Iterable<Province> findAllProvince();
}
