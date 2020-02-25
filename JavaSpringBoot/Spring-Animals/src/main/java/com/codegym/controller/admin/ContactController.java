package com.codegym.controller.admin;

import com.codegym.model.Contact;
import com.codegym.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym")
@Controller
@RequestMapping("/admin")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/list-contact")
    public ModelAndView contactList() {
        Iterable<Contact> contacts = contactService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/contact/list");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @GetMapping("/create-contact")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/contact/create");
        modelAndView.addObject("contact", new Contact());
        return modelAndView;
    }

    @PostMapping("/create-brand")
    public ModelAndView saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);

        ModelAndView modelAndView = new ModelAndView("/admin/contact/create");
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("message", "New contact created successfully");
        return modelAndView;
    }
}
