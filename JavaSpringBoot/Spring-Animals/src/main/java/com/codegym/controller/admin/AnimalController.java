package com.codegym.controller.admin;

import com.codegym.model.Animals;
import com.codegym.model.AnimalsUpload;
import com.codegym.model.Coach;
import com.codegym.model.Species;
import com.codegym.service.AnimalsService;
import com.codegym.service.CoachService;
import com.codegym.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@ComponentScan("com.codegym")
@Controller
@RequestMapping("/admin")
public class AnimalsController {

    private static String UPLOADED_FOLDER = "D:\\Bootcamp-JAVA-Backend\\JavaSpringBoot\\Spring-Animals\\src\\main\\resources\\static\\images\\";

    @Autowired
    private AnimalsService animalsService;

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private CoachService coachService;

    @ModelAttribute("coaches")
    public Iterable<Coach> coaches(){return coachService.findAll();}

    @ModelAttribute("species")
    public Iterable<Species> species(){return speciesService.findAll();}

    @GetMapping("/list-animals")
    public ModelAndView animalsList() {
        Iterable<Animals> animals = animalsService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/animals/list");
        modelAndView.addObject("animals",animals);
        return modelAndView;
    }


    @GetMapping("/create-animals")
    public ModelAndView showCreateForm(@ModelAttribute("animalsUpload") AnimalsUpload animalsUpload) {
        ModelAndView modelAndView = new ModelAndView("/admin/animals/create");
        modelAndView.addObject("animalsUpload", new AnimalsUpload());
        modelAndView.addObject("animals", new Animals());
        return modelAndView;
    }

    @PostMapping("/create-animals")
    public ModelAndView addAnimals(@ModelAttribute("animalsUpload") AnimalsUpload animalsUpload,
                                   @RequestParam("file") MultipartFile file
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/admin/animals/create");

        if(file.isEmpty()){
            modelAndView.addObject("message", "Failed To Create New Product");
            return modelAndView;
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path,bytes);

            Animals animals = new Animals();
            animals.setName(animalsUpload.getName());
            animals.setAge(animalsUpload.getAge());
            animals.setGender(animalsUpload.getGender());
            animals.setSpecies(animalsUpload.getSpecies());
            animals.setComment(animalsUpload.getComment());
            animals.setImage(file.getOriginalFilename());
            animals.setCoach(animalsUpload.getCoach());
            animalsService.save(animals);

        } catch (IOException e){
            e.printStackTrace();
        }
        modelAndView.addObject("productUpload", new AnimalsUpload());
        modelAndView.addObject("message", "New Animals Was Created");
        return modelAndView;
    }

    @GetMapping("/edit-animals/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Animals animals = animalsService.findById(id);
        if (animals != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/animals/edit");
            modelAndView.addObject("animals", animals);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-animals")
    public ModelAndView updateAnimals(@ModelAttribute("animals") Animals animals) {
        animals.getId();
        animalsService.save(animals);
        ModelAndView modelAndView = new ModelAndView("/admin/animals/edit");
        modelAndView.addObject("animals", animals);
        modelAndView.addObject("message", "Animals Was Updated");
        return modelAndView;
    }

    @GetMapping("/delete-animals/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Animals animals = animalsService.findById(id);
        if (animals != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/animals/delete");
            modelAndView.addObject("animals", animals);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/layout/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-animals")
    public ModelAndView deleteProduct(@ModelAttribute("animals") Animals animals) {
        animalsService.remove(animals.getId());
        Iterable<Animals> animal = animalsService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/animals/list");
        modelAndView.addObject("animal",animal);
        return modelAndView;
    }
}
