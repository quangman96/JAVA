package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.repository.CategoryRepository;
import com.codegym.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class CategoryServiceImpl implements CategoryService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.isDelete = 0",
                Category.class);
        return query.getResultList();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void sortDelete(Long id) {
        categoryRepository.sortDelete(id);
    }

    @Override
    public Iterable<Category> findAllByIsDelete(Integer isDelete) {
        return categoryRepository.findAllByIsDelete(isDelete);
    }

}
