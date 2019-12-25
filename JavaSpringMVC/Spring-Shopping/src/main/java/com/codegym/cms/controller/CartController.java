package com.codegym.cms.controller;

import com.codegym.cms.model.Item;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.ProductService;
import com.codegym.cms.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "cart")
public class CartController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String cart() {
        return "/cart/cart";
    }

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public List<Item> getCart() {
        List<Item> items = new ArrayList<>();
        return items;
    }
    @GetMapping("/cart")
    public ModelAndView showCart(@ModelAttribute("cart") List<Item> cart, Model model) {
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("/buy/{id}")
    public String buyCart(@PathVariable int id, HttpSession session, Model model) {
        Item item;
        List<Item> cart;
        long total = 0;
        if (session.getAttribute("cart") == null ) {
            cart = new ArrayList<>();
            Product product = productService.findById(id);
            item = new Item(product,1);
            cart.add(item);
            session.setAttribute("cart",cart);
            total = product.getPrice();
        } else {
            cart = (List<Item>) session.getAttribute("cart");
            int index = this.isExisting(id,cart);
            if (index == -1) {
                Product product = productService.findById(id);
                item = new Item(product,1);
                cart.add(item);
            } else {
                int quantity = cart.get(index).getQuantity()+1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart",cart);
            for (int i = 0; i < cart.size(); i++) {
                total += cart.get(i).getProduct().getPrice() * cart.get(i).getQuantity();
            }
        }
        model.addAttribute("cart",cart);
        model.addAttribute("total", total);
        return "/cart/cart";
    }

    private int isExisting(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }
    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable int id, HttpSession session, Model model) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.isExisting(id,cart);
        cart.remove(index);
        session.setAttribute("cart",cart);
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getProduct().getPrice() * cart.get(i).getQuantity();
        }
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "/cart/cart";

    }
}
