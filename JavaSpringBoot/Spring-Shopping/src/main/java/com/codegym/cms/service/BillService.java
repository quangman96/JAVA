package com.codegym.cms.service;

import com.codegym.cms.model.Bill;
import org.springframework.stereotype.Service;

@Service
public interface BillService {
    Iterable<Bill> findAll();

    Bill findById(Long id);

    void save(Bill bill);
}
