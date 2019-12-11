package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface Service <T>{
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
