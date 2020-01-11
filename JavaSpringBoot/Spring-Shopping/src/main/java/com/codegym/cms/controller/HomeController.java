package com.codegym.cms.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.cms")
@RestController
public class HomeController {
    @GetMapping({"/","home"})
    public ModelAndView Home(){
        ModelAndView modelAndView = new ModelAndView("/layout/index");
        return modelAndView;

    }
}
