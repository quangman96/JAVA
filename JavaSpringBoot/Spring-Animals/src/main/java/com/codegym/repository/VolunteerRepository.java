package com.codegym.repository;

import com.codegym.model.Volunteer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer,Long> {
}
