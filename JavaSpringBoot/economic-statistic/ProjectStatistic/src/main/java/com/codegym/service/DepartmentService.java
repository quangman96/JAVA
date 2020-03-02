package com.codegym.service;

import com.codegym.model.Department;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    Iterable<Department>findAll();
    Department findId(Long id);
    void save(Department department);
    void delete(Long id);
    Iterable<Department> findAllDepartment();
    void deletedDepartment(@Param("id") Long id);
}
