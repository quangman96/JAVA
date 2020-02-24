package com.codegym.cms.controller;

import com.codegym.cms.model.Contact;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
@ComponentScan("com.codegym.cms")
@RestController

public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/api/contact")
    public ResponseEntity<Iterable<Contact>> contactListApi() {
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

    @GetMapping("/admin/list-contact")
    public ModelAndView contactList() {
        Iterable<Contact> contacts = contactService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }

    @GetMapping("/admin/delete-contact/{id}")
    public ModelAndView showContactForm(@PathVariable Long id) {
        Contact contact = contactService.findById(id);
        if (contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/delete");
            modelAndView.addObject("contact", contact);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/admin/delete-contact")
    public ModelAndView deleteContact(@ModelAttribute("contact") Contact contact) {
        contactService.remove(contact.getId());
        Iterable<Contact> contacts = contactService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }

}
