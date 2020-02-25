package com.codegym.repository;

import com.codegym.model.Coach;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoachRepository extends PagingAndSortingRepository<Coach,Long> {
}
