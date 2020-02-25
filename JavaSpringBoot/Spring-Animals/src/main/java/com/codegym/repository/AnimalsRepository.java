package com.codegym.repository;

import com.codegym.model.Animals;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimalsRepository extends PagingAndSortingRepository<Animals,Long> {
}
