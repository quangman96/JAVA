package com.codegym.cms.controller;

import com.codegym.cms.model.Product;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym.cms")
@RestController
public class LayoutController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id1}/{id2}")
    public ModelAndView showAllProductByCategoryAndBrand(@PathVariable Long id1, @PathVariable Long id2) {
        Iterable<Product> products = productService.findAllByCategoryAndBrand(id1, id2);
        if (products != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/categories");
            modelAndView.addObject("products", products);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @GetMapping("/brands/{id}")
    public ModelAndView showAllProductByBrand(@PathVariable Long id) {
        Iterable<Product> products = productService.findAllByBrand_Id(id);
        if (products != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/categories");
            modelAndView.addObject("products", products);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @GetMapping("/products/{id}")
    public ModelAndView showAllProductByCategory(@PathVariable Long id) {
        Iterable<Product> products = productService.findAllByCategory_Id(id);
        if (products != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/categories");
            modelAndView.addObject("products", products);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @GetMapping("/product/{id}")
    public ModelAndView viewProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/layout/product");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @GetMapping("/contact")
    public ModelAndView showContactForm() {
        ModelAndView modelAndView = new ModelAndView("/layout/contact");
        return modelAndView;
    }
}

