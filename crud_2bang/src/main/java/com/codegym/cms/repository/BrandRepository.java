package com.codegym.cms.repository;

import com.codegym.cms.model.Brand;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends PagingAndSortingRepository<Brand,Long> {
}
