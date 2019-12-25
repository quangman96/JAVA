package com.codegym.cms.controller;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import com.codegym.cms.model.ProductUpload;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if(target == null) {
            return;
        }
        if(target.getClass() == Product.class){
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
    @Autowired
    private BrandService brandService;

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
    public ModelAndView showCreateForm(@ModelAttribute("productUpload") ProductUpload productUpload) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("productUpload", new ProductUpload());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView addProduct(HttpServletRequest request, @ModelAttribute("productUpload") ProductUpload productUpload) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
//        if (result.hasErrors()){
//            System.out.println("Result Error Occured" + result.getAllErrors());
//            modelAndView.addObject("message", "404");
//        }

        Product product = new Product();
        product.setName(productUpload.getName());
        product.setAmount(productUpload.getAmount());
        product.setBrand(productUpload.getBrand());
        product.setPrice(productUpload.getPrice());
        product.setImage(productUpload.getImage());
        productService.save(product);

        String uploadRootPath = request.getServletContext().getRealPath("/images");
        File uploadRootDir = new File(uploadRootPath);
        if(!uploadRootDir.exists()){
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = productUpload.getFileDatas();
        Map<File,String> uploadFile = new HashMap<>();
        for (CommonsMultipartFile fileData : fileDatas) {
            String name = fileData.getOriginalFilename();
            if( name != null && name.length()>0) {
                try {
                    File serverFile = new File(uploadRootDir.getAbsolutePath()+File.separator+ name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadFile.put(serverFile,name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        modelAndView.addObject("productUpload", new ProductUpload());
        modelAndView.addObject("message","New Product Was Created");
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Product product = null;
        try {
            product = productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public ModelAndView showDeleteForm(@PathVariable int id) throws Exception {
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
