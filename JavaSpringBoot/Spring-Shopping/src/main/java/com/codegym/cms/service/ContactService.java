package com.codegym.cms.service;

import com.codegym.cms.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Iterable<Contact> findAll();

    Contact findById(Long id);

    void save(Contact contact);

    void remove(Long id);
}
