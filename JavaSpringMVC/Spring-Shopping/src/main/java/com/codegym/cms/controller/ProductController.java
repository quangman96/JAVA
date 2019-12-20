package com.codegym.cms.controller;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Photo;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;
    private static String UPDATE_LOCATION  = "D:\\Bootcamp-JAVA-Backend\\JavaSpringMVC\\Spring-Shopping\\src\\main\\webapp\\images\\";

    @ModelAttribute("brands")
    public Iterable<Brand> brands(){
        return brandService.findAll();
    }
    @GetMapping("/list-product")
    public ModelAndView productList(){
        Iterable<Product> products = productService.findAll();

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
//        modelAndView.addObject("photo",new Photo());
        return modelAndView;
    }
//    @PostMapping("/create-product")
//    public ModelAndView saveProduct(@ModelAttribute("product") Product product){
//        productService.save(product);
//        ModelAndView modelAndView = new ModelAndView("/product/create");
//        modelAndView.addObject("product", new Product());
//        modelAndView.addObject("message","New Product Was Created");
//        return modelAndView;
//    }
@PostMapping("/create-product")
public ModelAndView addProduct(@ModelAttribute("photo") Photo photo, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView("/product/create");
    if (bindingResult.hasErrors()) {
        System.out.println("Result Error Occured" + bindingResult.getAllErrors());
        modelAndView.addObject("message", "404");
    }
    //lay ten file
    MultipartFile multipartFile = photo.getFile();
    String fileName = multipartFile.getOriginalFilename();
    //lu tru file len sever

    try {

        FileCopyUtils.copy(photo.getFile().getBytes(), new File(UPDATE_LOCATION + fileName));
        Product product = new Product(photo.getId(), photo.getName(), photo.getAmount(),photo.getPrice(),fileName);
        productService.save(product);
        modelAndView.addObject("message", "OK");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return modelAndView;
}
    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product",product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product")Product product){
        product.getId();
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message","Product Was Updated");
        return  modelAndView;
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Product product = productService.findById(id);
        if(product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.remove(product.getId());
        return "redirect:list-product";
    }

}
