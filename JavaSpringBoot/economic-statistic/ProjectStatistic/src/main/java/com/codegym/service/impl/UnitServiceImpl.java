package com.codegym.service.impl;

import com.codegym.model.Unit;
import com.codegym.repository.UnitRepository;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Iterable<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Unit findId(Long id) {
        return unitRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    public void delete(Long id) {
        unitRepository.deleteById(id);
    }

    @Override
    public Iterable<Unit> findAllUnit() {
        return unitRepository.findAllUnit();
    }

    @Override
    public void deletedUnit(Long id) {
unitRepository.deletedUnit(id);
    }
}
