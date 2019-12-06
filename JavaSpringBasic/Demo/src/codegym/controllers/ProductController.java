package codegym.controllers;

import codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import codegym.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> products = this.productService.fillAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateFrom(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        int randomId = (int)(Math.random()*10000);
        product.setId(randomId);
        this.productService.save(product);

        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message","New product was created");
        return modelAndView;
    }

    @GetMapping(value ="/view")
    public ModelAndView view(@RequestParam("id") Integer productId){
        Product product = this.productService.fillById(productId);
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

}
