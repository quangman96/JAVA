
package com.codegym.controller;

import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        ProductServiceImpl productService = new ProductServiceImpl();
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

}
