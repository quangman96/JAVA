package com.codegym.repository;

import com.codegym.model.District;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DistrictRepository extends PagingAndSortingRepository<District,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE district SET is_deleted = 1 WHERE id_district = ?;", nativeQuery = true)
    void deletedDistrict(@Param("id") Long id);
    @Query(value = "SELECT * FROM district WHERE is_deleted = 0;", nativeQuery = true)
    Iterable<District> findAllDistrict();
}
