package com.codegym.cms.service.impl;

import com.codegym.cms.model.Category;
import com.codegym.cms.model.Contact;
import com.codegym.cms.repository.ContactRepository;
import com.codegym.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);

    }

    @Override
    public void remove(Long id) {
        contactRepository.deleteById(id);
    }
}
