package com.codegym.repository;

import com.codegym.model.Images;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ImagesRepository extends PagingAndSortingRepository <Images, Long> {
}
