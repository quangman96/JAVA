package com.codegym.cms.controller;

import com.codegym.cms.model.*;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.CategoryService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;


@ComponentScan("com.codegym.cms")
@RestController
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;


    @ModelAttribute("brands")
    public Iterable<Brand> brands() {
        return brandService.findAll();
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/list-abc")
    public ResponseEntity<Iterable<Product>> productList() {
        Iterable<Product> products = productService.findAll();
        if (products == null) {
            return new ResponseEntity<Iterable<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/list-product")
    public ModelAndView abc() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }


    @GetMapping("/create-product")
    public ModelAndView showCreateForm(@ModelAttribute("productUpload") ProductUpload productUpload) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("productUpload", new ProductUpload());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView addProduct(@ModelAttribute("productUpload") ProductUpload productUpload
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/product/create");

        MultipartFile file = productUpload.getFile();
        productService.upLoadFile(file);
        String name = file.getOriginalFilename();

        Product product = new Product();
        product.setName(productUpload.getName());
        product.setAmount(productUpload.getAmount());
        product.setBrand(productUpload.getBrand());
        product.setCategory(productUpload.getCategory());
        product.setPrice(productUpload.getPrice());
        product.setImage(name);
        product.setComment(productUpload.getComment());
        productService.save(product);

        modelAndView.addObject("productUpload", new ProductUpload());
        modelAndView.addObject("message", "New Product Was Created");
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        product.getId();
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product Was Updated");
        return modelAndView;
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.sortDelete(product.getId());
        return "redirect:/admin/list-product";
    }
}
