package com.codegym.controller;

import com.codegym.model.Department;
import com.codegym.model.ProductType;
import com.codegym.service.DepartmentService;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private DepartmentService departmentService;
    @ModelAttribute("department")
    public Iterable<Department>departments(){
        return departmentService.findAll();
    }
    @GetMapping("/listProducType")
    public ModelAndView showList(){
        Iterable<ProductType> productTypes = productTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/producttype/list");
        modelAndView.addObject("producttypes",productTypes);
        return modelAndView;
    }
    @GetMapping("/createProducttype")
    public ModelAndView showForm(@ModelAttribute("producttype") ProductType producttype){
        ModelAndView modelAndView = new ModelAndView("/producttype/create");
        modelAndView.addObject("producttype",new ProductType());
        return modelAndView;
    }
  @PostMapping("/createProducttype")
    public ModelAndView createProductType(@ModelAttribute("producttype") ProductType producttype){
        productTypeService.save(producttype);
        ModelAndView modelAndView = new ModelAndView("/producttype/create");
        modelAndView.addObject("producttype",new ProductType());
        return modelAndView;
    }
}
