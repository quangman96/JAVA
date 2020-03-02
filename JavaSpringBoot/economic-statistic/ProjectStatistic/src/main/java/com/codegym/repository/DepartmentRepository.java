package com.codegym.repository;

import com.codegym.model.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends PagingAndSortingRepository<Department,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE department SET is_deleted = 1 WHERE id_department = ?;", nativeQuery = true)
    void deletedDepartment(@Param("id") Long id);
    @Query(value = "SELECT * FROM department WHERE is_deleted = 0;", nativeQuery = true)
    Iterable<Department> findAllDepartment();
}
