package com.codegym.service.impl;

import com.codegym.model.DataType;
import com.codegym.repository.DataTypeRepository;
import com.codegym.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataTypeServiceImpl implements DataTypeService {
    @Autowired
    private DataTypeRepository dataTypeRepository;

    @Override
    public Iterable<DataType> findAll() {
        return dataTypeRepository.findAll();
    }

    @Override
    public DataType findId(Long id) {
        return dataTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DataType dataType) {
        dataTypeRepository.save(dataType);
    }

    @Override
    public void delete(Long id) {
        dataTypeRepository.deleteById(id);
    }

    @Override
    public Iterable<DataType> findAllDataType() {
        return dataTypeRepository.findAllDataType();
    }

    @Override
    public void deletedDataType(Long id) {
        dataTypeRepository.deletedDataType(id);
    }
}
