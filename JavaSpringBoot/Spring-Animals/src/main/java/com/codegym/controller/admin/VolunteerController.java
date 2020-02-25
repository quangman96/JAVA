package com.codegym.controller.admin;

import com.codegym.model.Volunteer;
import com.codegym.service.VolunteerService;
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
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @GetMapping("/list-volunteer")
    public ModelAndView volunteerList() {
        Iterable<Volunteer> volunteers = volunteerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/volunteer/list");
        modelAndView.addObject("volunteers", volunteers);
        return modelAndView;
    }

    @GetMapping("/create-volunteer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/volunteer/create");
        modelAndView.addObject("volunteer", new Volunteer());
        return modelAndView;
    }

    @PostMapping("/create-volunteer")
    public ModelAndView saveVolunteer(@ModelAttribute("volunteer") Volunteer volunteer) {
        volunteerService.save(volunteer);

        ModelAndView modelAndView = new ModelAndView("/admin/volunteer/create");
        modelAndView.addObject("volunteer", new Volunteer());
        modelAndView.addObject("message", "New volunteer created successfully");
        return modelAndView;
    }
}
