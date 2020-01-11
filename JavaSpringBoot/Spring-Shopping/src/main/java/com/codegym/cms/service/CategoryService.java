package com.codegym.cms.service;

import com.codegym.cms.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void sortDelete(int id);

    Iterable<Category> findAllByIsDelete(Integer isDelete);


}
