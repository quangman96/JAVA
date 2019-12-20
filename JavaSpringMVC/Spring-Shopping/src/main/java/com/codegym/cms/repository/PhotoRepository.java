package com.codegym.cms.repository;

import com.codegym.cms.model.Photo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhotoRepository extends PagingAndSortingRepository<Photo,Integer> {
}
