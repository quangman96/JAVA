package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.Unit;
import com.codegym.service.ProductService;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UnitController {
  @Autowired
    private UnitService unitService;
  @Autowired
  private ProductService productService;
    @ModelAttribute("product")
    public Iterable<Product> products(){
        return productService.findAllProduct();
    }
    @GetMapping("/listUnit")
    public ModelAndView list(){
        Iterable<Unit> units= unitService.findAll();
        ModelAndView modelAndView= new ModelAndView("/unit/list");
        modelAndView.addObject("units",units);
        return modelAndView;
    }
    @GetMapping("/createUnit")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/unit/create");
        modelAndView.addObject("unit", new Unit());
        return modelAndView;
    }
    @PostMapping("/createUnit")
    public ModelAndView createDistrict(@ModelAttribute("unit") Unit unit){
        unitService.save(unit);
        ModelAndView modelAndView = new ModelAndView("/unit/create");
        modelAndView.addObject("unit",new Unit());
        return modelAndView;
    }
}
