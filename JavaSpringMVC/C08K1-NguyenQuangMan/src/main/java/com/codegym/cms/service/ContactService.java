package com.codegym.cms.service;

import com.codegym.cms.model.Contact;

public interface ContactService {
    Iterable<Contact> findAll();

    Contact findById(int id);

    void save (Contact contact);

    void softDeleteById(int id);

}
