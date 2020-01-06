package com.codegym.cms.controller;

import com.codegym.cms.model.Brand;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.BrandService;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;
    @GetMapping("/list-brand")
    public ModelAndView BrandList() {
        Iterable<Brand> brands = brandService.findAll();

        ModelAndView modelAndView = new ModelAndView("brand/list");
        modelAndView.addObject("brands",brands);
        return modelAndView;
    }

    @GetMapping("/create-brand")
    public ModelAndView ShowCreateBrand() {
        ModelAndView modelAndView = new ModelAndView("/brand/create");
        modelAndView.addObject("brand",new Brand());
        return modelAndView;
    }
    @PostMapping("/create-brand")
    public ModelAndView saveBrand(@ModelAttribute("brand") Brand brand){
        brandService.save(brand);

        ModelAndView modelAndView = new ModelAndView("/brand/create");
        modelAndView.addObject("brand", new Brand());
        modelAndView.addObject("message","OK");
        return  modelAndView;
    }
    @GetMapping("/edit-brand/{id}")
    public ModelAndView ShowEditForm(@PathVariable Long id) {
        Brand brand = brandService.findById(id);
        if(brand != null) {
            ModelAndView modelAndView = new ModelAndView("/brand/edit");
            modelAndView.addObject("brand",brand);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-brand")
    public ModelAndView UpdateBrand(@ModelAttribute("brand")Brand brand){
        brandService.save(brand);
        ModelAndView modelAndView = new ModelAndView("/brand/edit");
        modelAndView.addObject("brand",brand);
        modelAndView.addObject("message","OK");
        return modelAndView;
    }
    @GetMapping("/delete-brand/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Brand brand = brandService.findById(id);

        if(brand != null) {
            ModelAndView modelAndView = new ModelAndView("/brand/delete");
            modelAndView.addObject("brand",brand);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }
    @PostMapping("delete-brand")
    public String removeBrand(@ModelAttribute("brand")Brand brand){
        brandService.remove(brand.getId());
        return "redirect:list-brand";
    }
    @GetMapping("/view-brand/{id}")
    public ModelAndView viewBrand(@PathVariable("id") Long id){
        Brand brand = brandService.findById(id);
        if(brand == null){
            return new ModelAndView("/404");
        }
        Iterable<Product> products = productService.findAllByBrand(brand);

        ModelAndView modelAndView = new ModelAndView("/brand/view");
        modelAndView.addObject("brand",brand);
        modelAndView.addObject("products",products);
        return  modelAndView;
    }
}
