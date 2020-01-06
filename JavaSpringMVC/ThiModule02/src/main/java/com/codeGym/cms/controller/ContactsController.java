package com.codeGym.cms.controller;

import com.codeGym.cms.model.Contacts;
import com.codeGym.cms.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ContactsController {
    @Autowired
    private ContactsService contactsService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ModelAndView listContacts(@RequestParam("fol") Optional<String> fol,@RequestParam("f") Optional<String> f,@RequestParam("l") Optional<String> l){
        Iterable<Contacts> contactsList;
        if (f.isPresent()){
            contactsList = contactsService.findAllByFirstNameContaining(f.get());
        }
        else if (l.isPresent()){
            contactsList = contactsService.findAllByLastNameContaining(l.get());
        }
        else if (fol.isPresent()){
            contactsList = contactsService.findAllByFirstNameOrLastNameContaining(fol.get(),fol.get());
        }
        else{
            contactsList = contactsService.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("/contacts/list");
        modelAndView.addObject("contactsList", contactsList);
        return modelAndView;
    }
    @RequestMapping(value = "/create-contact", method = RequestMethod.GET)
    public ModelAndView showCreateContactForm(){
        ModelAndView modelAndView = new ModelAndView("/contacts/create");
        modelAndView.addObject( "contacts", new Contacts());
        return modelAndView;
    }
    @RequestMapping(value = "/create-contact", method = RequestMethod.POST)
    public ModelAndView saveContact(@Validated @ModelAttribute("contacts") Contacts contacts, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/contacts/create");
        }
        else {
            contactsService.save(contacts);
            ModelAndView modelAndView = new ModelAndView("/contacts/create");
            modelAndView.addObject("contacts", new Contacts());
            modelAndView.addObject("message", "New contact created successfully");
            return modelAndView;
        }
    }
    @RequestMapping(value = "/edit-contact/{id}", method = RequestMethod.GET)
    public ModelAndView showEditContactForm(@PathVariable long id){
        Contacts contacts = contactsService.findById(id);
        if (contacts == null){
            return new ModelAndView("/error.404");
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/contacts/edit");
            modelAndView.addObject("contacts", contacts);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/edit-contact", method = RequestMethod.POST)
    public ModelAndView updateContact(@Validated @ModelAttribute("contacts") Contacts contacts, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/contacts/edit");
        }
        else {
            contactsService.save(contacts);
            ModelAndView modelAndView = new ModelAndView("/contacts/edit");
            modelAndView.addObject("contacts", contacts);
            modelAndView.addObject("message", "Contacts updated successfully");
            return modelAndView;}
    }
    @RequestMapping(value = "/delete-contact/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteContactForm(@PathVariable long id){
        Contacts contacts = contactsService.findById(id);
        if (contacts == null){
            return new ModelAndView("/error.404");
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/contacts/delete");
            modelAndView.addObject("contacts", contacts);
            return modelAndView;
        }
    }
    @RequestMapping(value = "/delete-contact", method = RequestMethod.POST)
    public String deleteContact(@ModelAttribute("contacts")Contacts contacts){
        contactsService.remove(contacts.getId());
        return "redirect:/contacts";
    }
}
