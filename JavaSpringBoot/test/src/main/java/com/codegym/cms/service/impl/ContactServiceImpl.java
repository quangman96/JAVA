package com.codegym.cms.service.impl;

import com.codegym.cms.model.Contact;
import com.codegym.cms.repository.ContactRepository;
import com.codegym.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
@Repository
public class ContactServiceImpl implements ContactService {
    @PersistenceContext
    EntityManager em;


    @Autowired
    ContactRepository contactRepository;
    @Override
    public Iterable<Contact> findAll() {
        TypedQuery<Contact> query = em.createQuery("SELECT c FROM Contact c WHERE c.isDelete = 0"
                , Contact.class);
        return query.getResultList();
    }

    @Override
    public Contact findById(int id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void softDeleteById(int id){
        contactRepository.softDeleteById(id);
    }
}
