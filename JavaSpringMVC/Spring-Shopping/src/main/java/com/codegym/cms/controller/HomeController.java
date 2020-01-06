package com.codegym.cms.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping({"/","home"})
    public ModelAndView Home(){
        ModelAndView modelAndView = new ModelAndView("/layout/index");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public String Login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error","Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("logout","You have been logged out successfully.");
        return "/admin/list-product";
    }
    @GetMapping(value = {"/success","/welcome"})
    public String Welcome(Model model) {
        return "/list-product";
    }

    @GetMapping("/admin")
    public String adminPage(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "/admin/list-product";
    }

    @PostMapping("/logout")
    public String logoutToHomePage(){
        return "/layout/index";
    }
}
