package com.codegym.service.impl;

import com.codegym.model.Contact;
import com.codegym.repository.ContactRepository;
import com.codegym.service.ContactService;
import org.springframework.stereotype.Repository;

@Repository
public class ContactImpl implements ContactService {
    private ContactRepository contactRepository;

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
