package com.codegym.cms.repository;

import com.codegym.cms.model.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillRepository extends PagingAndSortingRepository<Bill,Long> {

}
