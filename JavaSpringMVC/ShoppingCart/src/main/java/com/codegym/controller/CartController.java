

package com.codegym.controller;

import com.codegym.model.Item;
import com.codegym.model.Product;
import com.codegym.service.ProductServiceImpl;
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

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "cart/index";
    }

    private ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @ModelAttribute("cart")
    public List<Item> getCart() {
        List<Item> items = new ArrayList<>();
        return items;
    }

    @GetMapping("/cart")
    public ModelAndView showCart(@ModelAttribute("cart") List<Item> cart, Model model) {
        ModelAndView modelAndView = new ModelAndView("/cart/index");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
    @GetMapping("/buy/{id}")
    public String buy(@PathVariable int id, HttpSession session,Model model) {

        Item item;
        List<Item> cart;
        double total = 0;
        if (session.getAttribute("cart") == null) {
            cart = new ArrayList<>();
            Product product = productServiceImpl.findById(id);
            item = new Item(product,1);
            cart.add(item);
            session.setAttribute("cart", cart);
            total = product.getPrice();

        } else {
            cart = (List<Item>) session.getAttribute("cart");
            int index = this.isExisting(id, cart);
            if (index == -1) {
                Product product = productServiceImpl.findById(id);
                item = new Item(product,1);
                cart.add(item);
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
            for (int i = 0; i < cart.size(); i++) {
                total += cart.get(i).getProduct().getPrice() * cart.get(i).getQuantity();
            }
        }
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "/cart/index";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable int id, HttpSession session,Model model) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.isExisting(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getProduct().getPrice() * cart.get(i).getQuantity();
        }
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart/index";
    }


    private int isExisting(int id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
