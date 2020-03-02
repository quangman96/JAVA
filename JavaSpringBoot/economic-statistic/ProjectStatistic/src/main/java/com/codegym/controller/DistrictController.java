package com.codegym.controller;

import com.codegym.model.District;
import com.codegym.model.Province;
import com.codegym.service.DistrictService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @Autowired
    private ProvinceService provinceService;
    @ModelAttribute("province")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
    @GetMapping("/listDistrict")
    public ModelAndView list(){
        Iterable<District> districts= districtService.findAll();
        ModelAndView modelAndView= new ModelAndView("/district/list");
        modelAndView.addObject("districts",districts);
        return modelAndView;
    }
    @GetMapping("/createDistrict")
    public ModelAndView showForm(@ModelAttribute("district") District district){
        ModelAndView modelAndView = new ModelAndView("/district/create");
        modelAndView.addObject("district", new District());
        return modelAndView;
    }
    @PostMapping("/createDistrict")
    public ModelAndView createDistrict(@ModelAttribute("district") District district){
        districtService.save(district);
        ModelAndView modelAndView = new ModelAndView("/district/create");
        modelAndView.addObject("district",new District());
        return modelAndView;
    }
}
