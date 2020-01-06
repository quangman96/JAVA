package com.codeGym.cms.service.impl;

import com.codeGym.cms.model.Contacts;
import com.codeGym.cms.repository.ContactsRepository;
import com.codeGym.cms.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactsServiceImpl implements ContactsService {
    @Autowired
    ContactsRepository contactsRepository;
    @Override
    public Iterable<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    @Override
    public Iterable<Contacts> findAllByFirstNameContaining(String firstName) {
        return contactsRepository.findAllByFirstNameContaining(firstName);
    }

    @Override
    public Iterable<Contacts> findAllByLastNameContaining(String lastName) {
        return contactsRepository.findAllByLastNameContaining(lastName);
    }

    @Override
    public Iterable<Contacts> findAllByFirstNameOrLastNameContaining(String firstName, String lastName) {
        return contactsRepository.findAllByFirstNameOrLastNameContaining(firstName,lastName);
    }

    @Override
    public Contacts findById(Long id) {
        return contactsRepository.findById(id).get();
    }

    @Override
    public void save(Contacts contacts) {
        contactsRepository.save(contacts);
    }

    @Override
    public void remove(Long id) {
        contactsRepository.deleteById(id);
    }
}
