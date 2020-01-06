package com.codeGym.cms.service;

import com.codeGym.cms.model.Contacts;

public interface ContactsService {
    Iterable<Contacts> findAll();
    Iterable<Contacts> findAllByFirstNameContaining(String firstName);
    Iterable<Contacts> findAllByLastNameContaining(String lastName);
    Iterable<Contacts> findAllByFirstNameOrLastNameContaining(String firstName,String lastName );
    Contacts findById(Long id);
    void save(Contacts contacts);
    void remove(Long id);
}
