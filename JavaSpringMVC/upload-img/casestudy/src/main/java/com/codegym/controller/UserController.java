package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @ModelAttribute("users")
    public Iterable<User> users(){
        return userService.findAll();
    }
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("layout/layout");
        return modelAndView;
    }
    @GetMapping("/users")
    public ModelAndView listUsers(){
        Iterable<User> users =userService.findAll();
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @GetMapping("/create-user")

    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")

    public ModelAndView saveUser(@ModelAttribute("user") User user) {

        userService.save(user);

        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "tao thanh cong");
        return modelAndView;
    }
    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        User user = userService.findbyId(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("user/edit");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-user")
    public ModelAndView updateProvince(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("user/edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "sua thanh cong");
        return modelAndView;
    }
    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        User user = userService.findbyId(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("user/delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteProvince(@ModelAttribute("user") User user){
        userService.remove(user.getId());
        return "redirect:users";
    }

}
