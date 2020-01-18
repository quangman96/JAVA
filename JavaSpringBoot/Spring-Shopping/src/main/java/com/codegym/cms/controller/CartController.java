package com.codegym.cms.controller;

import com.codegym.cms.model.Cart;
import com.codegym.cms.model.Item;
import com.codegym.cms.model.Product;
import com.codegym.cms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ComponentScan("com.codegym.cms")
@Controller
@SessionAttributes("cart")
@RequestMapping(value = "cart")
public class CartController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String cart() {
        return "/layout/cart";
    }

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    private Cart setCart() {
        return new Cart();
    }


    @GetMapping("/cart")
    public ModelAndView cart(@ModelAttribute("cart") Cart cart) {
        int total = 0;
        ModelAndView modelAndView = new ModelAndView("layout/cart", "cart", cart);
        for (Item p : cart.getItems()) {
            total += p.getPrice() * p.getQuantity();
        }
        modelAndView.addObject("total", total);
        return modelAndView;
    }


    @GetMapping("/buy/{id}")
    public String buyCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        String quantity = "1";
        Product product = productService.findById(id);

        boolean check = true;
        for (Item item : cart.getItems()) {
            if (id.equals(item.getProduct().getId())) {
                item.setQuantity(item.getQuantity() + Long.parseLong(quantity));
                check = false;
            }
        }

        if (check) {
            Item item = new Item();
            item.setProduct(product);
            item.setQuantity(Long.parseLong(quantity));
            item.setPrice(product.getPrice());
            List<Item> itemList = new ArrayList<>();
            itemList = cart.getItems();
            itemList.add(item);
            cart.setItems(itemList);
        }
        return "redirect:/cart/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        for (Item item : cart.getItems()) {
            if (id.equals(item.getProduct().getId())) {
//                item.g().remove(p);
                break;
            }
        }
        return "redirect:/cart/cart";
    }

    @GetMapping("/quantity/{operator}/{id}")
    public String quantity(@PathVariable String operator, @PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        int quantity = 1;

        for (Item item : cart.getItems()) {
            if (id.equals(item.getProduct().getId())) {
                if (operator.equals("+")) {
                    item.setQuantity(item.getQuantity() + quantity);
                } else {
                    if (item.getQuantity() != 1) {
                        item.setQuantity(item.getQuantity() - quantity);
                    } else {
                        cart.getItems().remove(item);
                        break;
                    }
                }
            }
        }
        return "redirect:/cart/cart";
    }
}
