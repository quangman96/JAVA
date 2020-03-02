package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.model.Unit;
import com.codegym.service.ProductService;
import com.codegym.service.ProductTypeService;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private UnitService unitService;

    @ModelAttribute("producttype")
    public Iterable<ProductType> productTypes(){
        return productTypeService.findAll();

    }
    @ModelAttribute("unit")
    public Iterable<Unit> units(){
        return unitService.findAll();
    }

    @GetMapping("/listProduct")
    public ModelAndView showList(){
        Iterable<Product> products= productService.findALlProduct();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/createProduct")
    public ModelAndView showForm(@ModelAttribute("product") Product product){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
   @PostMapping("/createProduct")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product",new Product());
        modelAndView.addObject("product",unitService.findAll());
        modelAndView.addObject("message","a new Product was create");
        return modelAndView;
    }
}
