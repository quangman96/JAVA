package com.codegym.repository;

import com.codegym.model.Species;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpeciesRepository extends PagingAndSortingRepository<Species,Long> {
}
