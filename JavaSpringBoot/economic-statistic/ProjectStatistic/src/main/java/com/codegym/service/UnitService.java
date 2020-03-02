package com.codegym.service;

import com.codegym.model.Unit;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface UnitService {
    Iterable<Unit>findAll();
    Unit findId(Long id);
    void save(Unit unit);
    void delete(Long id);
    Iterable<Unit> findAllUnit();
    void deletedUnit(@Param("id") Long id);
}
