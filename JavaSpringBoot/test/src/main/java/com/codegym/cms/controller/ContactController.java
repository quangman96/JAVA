package com.codegym.cms.controller;

import com.codegym.cms.model.Contact;
import com.codegym.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.cms")
@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public ModelAndView ContactList() {
        Iterable<Contact> contacts = contactService.findAll();
        ModelAndView modelAndView = new ModelAndView("/contact/list");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }

    @GetMapping("/create-contact")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }

    @PostMapping("/create-contact")
    public ModelAndView addContact(@Validated @ModelAttribute("contact") Contact contact) {
        contactService.save(contact);
        ModelAndView modelAndView = new ModelAndView("/contact/create");
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("message","OK");
        return modelAndView;
    }

    @GetMapping("/edit-contact/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Contact contact = contactService.findById(id);
        if(contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/edit");
            modelAndView.addObject( "contact",contact);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/contact/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-contact")
    public ModelAndView updateContact(@Validated @ModelAttribute("contact")Contact contact){
//        contact.getId();
        contactService.save(contact);
        ModelAndView modelAndView = new ModelAndView("/contact/edit");
        modelAndView.addObject("contact", contact);
        modelAndView.addObject("message","Contact Was Updated");
        return  modelAndView;
    }

    @GetMapping("/delete-contact/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Contact contact = contactService.findById(id);
        if(contact != null) {
            ModelAndView modelAndView = new ModelAndView("/contact/delete");
            modelAndView.addObject("contact", contact);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/contact/404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-contact")
    public String deleteContact(@ModelAttribute("contact") @Param("id") Contact contact
    ){
        contactService.softDeleteById(contact.getId());
        return "redirect:/";
    }
}
