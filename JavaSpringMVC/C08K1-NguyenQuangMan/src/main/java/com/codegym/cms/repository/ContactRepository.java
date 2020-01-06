package com.codegym.cms.repository;

import com.codegym.cms.model.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ContactRepository extends PagingAndSortingRepository<Contact,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Contact c SET c.isDelete = 1 WHERE c.id= :id")
    void softDeleteById(@Param("id") int id);
}
