package com.codegym.repository;

import com.codegym.model.Service;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRepository extends PagingAndSortingRepository<Service,Long> {
}
