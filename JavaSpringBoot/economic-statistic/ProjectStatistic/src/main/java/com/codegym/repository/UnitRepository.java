package com.codegym.repository;

import com.codegym.model.Unit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UnitRepository extends PagingAndSortingRepository<Unit,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE unitquantity SET is_deleted = 1 WHERE id_unit = ?;", nativeQuery = true)
    void deletedUnit(@Param("id") Long id);
    @Query(value = "select * from unitquantity where is_deleted = 0;", nativeQuery = true)
    Iterable<Unit> findAllUnit();
}
