package com.codegym.service;

import com.codegym.model.DataType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface DataTypeService {
    Iterable<DataType>findAll();
    DataType findId(Long id);
    void save(DataType dataType);
    void delete(Long id);
    Iterable<DataType> findAllDataType();
    void deletedDataType(@Param("id") Long id);
}
