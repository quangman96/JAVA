package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Brand b SET b.isDelete = 1 WHERE b.id= :id")
    void sortDelete(@Param("id") int id);
}
