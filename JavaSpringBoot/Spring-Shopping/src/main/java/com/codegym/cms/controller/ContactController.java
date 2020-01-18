package com.codegym.cms.controller;

import com.codegym.cms.model.Contact;
import com.codegym.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/api/contact")
    public ResponseEntity<Iterable<Contact>> contactList() {
        Iterable<Contact> contacts = contactService.findAll();
        if (contacts == null) {
            return new ResponseEntity<Iterable<Contact>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Contact>>(contacts, HttpStatus.OK);
    }

    @PostMapping("/api/contact")
    public ResponseEntity<Void> createContact(@RequestBody Contact contact, UriComponentsBuilder uriComponentsBuilder) {
        contactService.save(contact);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/contact")
    public ModelAndView showContactForm() {
        ModelAndView modelAndView = new ModelAndView("/layout/contact");
        return modelAndView;
    }
}
