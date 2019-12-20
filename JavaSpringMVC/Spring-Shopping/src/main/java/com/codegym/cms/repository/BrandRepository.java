package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface BrandRepository extends PagingAndSortingRepository<Brand,Integer> {
//    void deleteAllByBrand_Id(Long id);
//@Transactional
//@Modifying
//@Query("update Province p set p.isDeleted = 1, p.deleted_at = :deleted_at, p.deleted_by = :deleted_by where p.id=:id")
//void softDelete(@Param("deleted_at") LocalDate deleted_at, @Param("deleted_by") String deleted_by, @Param("id") Long id);
}
