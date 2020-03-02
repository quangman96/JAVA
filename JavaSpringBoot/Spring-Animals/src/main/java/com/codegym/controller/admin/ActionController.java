package com.codegym.controller.admin;

import com.codegym.model.Service;
import com.codegym.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan("com.codegym")
@Controller
@RequestMapping("/admin")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/list-service")
    public ModelAndView serviceList() {
        Iterable<Service> services = serviceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/service/list");
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping("/create-service")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/create-service")
    public ModelAndView saveService(@ModelAttribute("service") Service service) {
        serviceService.save(service);

        ModelAndView modelAndView = new ModelAndView("/admin/service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("message", "New service created successfully");
        return modelAndView;
    }
}
