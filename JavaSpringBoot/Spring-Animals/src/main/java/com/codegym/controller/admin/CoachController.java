package com.codegym.controller.admin;

import com.codegym.model.*;
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
public class CoachController {
    private static String UPLOADED_FOLDER = "D:\\Bootcamp-JAVA-Backend\\JavaSpringBoot\\Spring-Animals\\src\\main\\resources\\static\\images\\";

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private CoachService coachService;

    @ModelAttribute("coaches")
    public Iterable<Coach> coaches(){return coachService.findAll();}

    @ModelAttribute("species")
    public Iterable<Species> species(){return speciesService.findAll();}

    @GetMapping("/list-coach")
    public ModelAndView coachList() {
        Iterable<Coach> coaches = coachService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/coach/list");
        modelAndView.addObject("coaches",coaches);
        return modelAndView;
    }


    @GetMapping("/create-coach")
    public ModelAndView showCreateForm(@ModelAttribute("coachUpload") CoachUpload coachUpload) {
        ModelAndView modelAndView = new ModelAndView("/admin/coach/create");
        modelAndView.addObject("coachUpload", new CoachUpload());
        modelAndView.addObject("coaches", new Coach());
        return modelAndView;
    }

    @PostMapping("/create-coach")
    public ModelAndView addAnimals(@ModelAttribute("coachUpload") CoachUpload coachUpload,
                                   @RequestParam("file") MultipartFile file
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/admin/coach/create");

        if(file.isEmpty()){
            modelAndView.addObject("message", "Failed To Create New Coach");
            return modelAndView;
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path,bytes);

            Coach coach = new Coach();
            coach.setName(coachUpload.getName());
            coach.setAge(coachUpload.getAge());
            coach.setGender(coachUpload.getGender());
            coach.setImage(file.getOriginalFilename());
            coachService.save(coach);

        } catch (IOException e){
            e.printStackTrace();
        }
        modelAndView.addObject("coachUpload", new CoachUpload());
        modelAndView.addObject("message", "New Coach Was Created");
        return modelAndView;
    }
}
