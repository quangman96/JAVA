package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@ComponentScan("com.codegym")
@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/listProvince")
    public ModelAndView list(){
        Iterable<Province> provinces =provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("province",provinces);
        return modelAndView;
    }
    @GetMapping("/createProvince")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
    @PostMapping("/createProvince")
    public ModelAndView create(@ModelAttribute("province") Province province){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        provinceService.save(province);
        modelAndView.addObject("province",new Province());
        return modelAndView;
    }
}
