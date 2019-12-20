package com.codegym.controller;

import com.codegym.model.Images;
import com.codegym.model.User;
import com.codegym.service.impl.ImagesService;
import com.codegym.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller

public class controller {
    private static String UPLOAD_LOCATION ="D:\\hoctap\\GIT\\webserviceANDrestful\\casestudy\\src\\main\\webapp\\theme\\images\\";
    @Autowired
    private UserService userService;
    @Autowired
    private ImagesService imagesService;
    @GetMapping("/customers")
    public ModelAndView listCustomers(){
        Iterable<User> users =userService.findAll();
        Iterable<Images> images = imagesService.findAll();
        ModelAndView modelAndView = new ModelAndView("done/list");
        modelAndView.addObject("users", users);
        modelAndView.addObject("images", images);
        return modelAndView;
    }
   }
