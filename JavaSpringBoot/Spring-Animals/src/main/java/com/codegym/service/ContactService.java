package com.codegym.service;

import com.codegym.model.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    Iterable<Contact> findAll();

    Contact findById(Long id);

    void save(Contact contact);

    void remove(Long id);
}
