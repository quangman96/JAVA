package com.codegym.cms.service.impl;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Category;
import com.codegym.cms.model.Product;
import com.codegym.cms.repository.ProductRepository;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.File;
import java.io.IOException;

@Repository
public class ProductServiceImpl implements ProductService {
    @PersistenceContext
    EntityManager em;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Iterable<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.isDelete = 0",
                Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Iterable<Product> findStar() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.star = 1",
                Product.class);
        return query.getResultList();
    }

    @Override
    public Iterable<Product> findAllByCategoryAndBrand(Long id1, Long id2) {
        return productRepository.findAllByCategoryAndBrand(id1, id2);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Product> findAllByBrand_Id(Long id) {
        return productRepository.findAllByBrand_Id(id);
    }

    @Override
    public Iterable<Product> findAllByCategory_Id(Long id) {
        return productRepository.findAllByCategory_Id(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void sortDelete(Long id) {
        productRepository.sortDelete(id);
    }

    @Override
    public Iterable<Product> findAllByBrand(Brand brand) {
        return productRepository.findAllByBrand(brand);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public void upLoadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("D:\\Bootcamp-JAVA-Backend\\JavaSpringBoot\\Spring-Shopping\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename()));
    }
}
