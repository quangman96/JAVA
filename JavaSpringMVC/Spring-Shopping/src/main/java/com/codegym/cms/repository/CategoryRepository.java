package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.isDelete = 1 WHERE c.id= :id")
    void sortDelete(@Param("id") int id);

    Iterable<Category> findAllByIsDelete(Integer isDelete);
}