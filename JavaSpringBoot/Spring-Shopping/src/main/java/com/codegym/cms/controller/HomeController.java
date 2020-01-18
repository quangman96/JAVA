package com.codegym.cms.controller;

import com.codegym.cms.model.Contact;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.ContactService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@ComponentScan("com.codegym.cms")
@RestController
public class HomeController {
    @Autowired
    ContactService contactService;

    @Autowired
    ProductService productService;

    @GetMapping({"/", "home"})
    public ModelAndView Home() {
        Iterable<Product> products = productService.findStar();
        ModelAndView modelAndView = new ModelAndView("/layout/index");
        modelAndView.addObject("products", products);
        return modelAndView;

    }

}
