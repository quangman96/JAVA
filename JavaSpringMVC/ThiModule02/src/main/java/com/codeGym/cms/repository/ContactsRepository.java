package com.codeGym.cms.repository;

import com.codeGym.cms.model.Contacts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactsRepository extends PagingAndSortingRepository<Contacts,Long> {
    Iterable<Contacts> findAllByFirstNameContaining(String firstName);
    Iterable<Contacts> findAllByLastNameContaining(String lastName);
    Iterable<Contacts> findAllByFirstNameOrLastNameContaining(String firstName,String lastName);

}
