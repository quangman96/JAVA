package com.codegym.service.impl;

import com.codegym.model.Department;
import com.codegym.repository.DepartmentRepository;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findId(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Department> findAllDepartment() {
        return departmentRepository.findAllDepartment();
    }

    @Override
    public void deletedDepartment(Long id) {
        departmentRepository.deletedDepartment(id);
    }
}
