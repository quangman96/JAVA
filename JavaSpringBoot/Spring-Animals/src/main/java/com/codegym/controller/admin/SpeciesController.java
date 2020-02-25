package com.codegym.controller.admin;

import com.codegym.model.Species;
import com.codegym.service.SpeciesService;
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
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/list-species")
    public ModelAndView speciesList() {
        Iterable<Species> species = speciesService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/species/list");
        modelAndView.addObject("species", species);
        return modelAndView;
    }

    @GetMapping("/create-species")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/species/create");
        modelAndView.addObject("species", new Species());
        return modelAndView;
    }

    @PostMapping("/create-species")
    public ModelAndView saveSpecies(@ModelAttribute("species") Species species) {
        speciesService.save(species);

        ModelAndView modelAndView = new ModelAndView("/admin/species/create");
        modelAndView.addObject("species", new Species());
        modelAndView.addObject("message", "New species created successfully");
        return modelAndView;
    }
}
