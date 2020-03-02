package com.codegym.controller.layout;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.cms")
@Controller
public class HomeController {

    @GetMapping({"/", "home"})
    public ModelAndView Home() {
        ModelAndView modelAndView = new ModelAndView("/layout/index");
        return modelAndView;

    }
}
