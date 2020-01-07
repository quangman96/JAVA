package com.codegym.cms.controller;

import com.codegym.cms.model.Product;
import com.codegym.cms.repository.ProductRepository;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LayoutController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands/{id}")
    public ModelAndView showAllProductByBrand(@PathVariable int id) {
        Iterable<Product> products = productService.findAllByBrand_Id(id);
        if (products != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/brands");
            modelAndView.addObject("products", products);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @GetMapping("/category/{id}")
    public ModelAndView showAllProductByCategory(@PathVariable int id) {
        Iterable<Product> products = productService.findAllByCategory_Id(id);
        if (products != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/categories");
            modelAndView.addObject("products",products);
            return modelAndView;
        } else {
            ModelAndView modelAndView  = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }
}

