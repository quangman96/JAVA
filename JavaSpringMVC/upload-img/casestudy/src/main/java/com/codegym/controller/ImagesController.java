package com.codegym.controller;

import com.codegym.model.FormImages;
import com.codegym.model.Images;
import com.codegym.model.User;
import com.codegym.service.impl.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class ImagesController {
    // duong dan luu anh
    private static String UPLOAD_LOCATION = "D:\\hoctap\\GIT\\webserviceANDrestful\\casestudy\\src\\main\\webapp\\theme\\images\\";
    @Autowired
    private ImagesService imagesService;

    @ModelAttribute("images")
    public Iterable<Images> images() {
        return imagesService.findAll();
    }

    @GetMapping("/images")
    public ModelAndView listImages() {
        Iterable<Images> images = imagesService.findAll();
        ModelAndView modelAndView = new ModelAndView("images/list");
        modelAndView.addObject("images", images);
        return modelAndView;
    }

    @GetMapping("/create-image")
    public ModelAndView addProductForm() {
        ModelAndView modelAndView = new ModelAndView("images/create");
        modelAndView.addObject("FormImages", new FormImages());
        return modelAndView;
    }

    @PostMapping("/done")
    public ModelAndView addProductSucess(@ModelAttribute("FormImages") FormImages formImages, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("images/create");
        if (bindingResult.hasErrors()) {
            System.out.println("Result Error Occured" + bindingResult.getAllErrors());
            modelAndView.addObject("message", "tao that bai");
        }
        //lay ten file
        MultipartFile multipartFile = formImages.getFile();
        String fileName = multipartFile.getOriginalFilename();
        //lu tru file len sever

        try {

            FileCopyUtils.copy(formImages.getFile().getBytes(), new File(UPLOAD_LOCATION + fileName));
            Images images = new Images(fileName, formImages.getNameImages(), formImages.getDescription());
            imagesService.save(images);
            modelAndView.addObject("message", "tao thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return modelAndView;
    }
    @GetMapping("edit-images/{id}")
    public ModelAndView editProduct(@PathVariable Long id ) {
        ModelAndView modelAndView = new ModelAndView("images/edit", "images" , imagesService.findbyId(id));
        return modelAndView;
    }

    @PostMapping("edit-images")
    public String editProductSuccess(@ModelAttribute("images") Images images , RedirectAttributes redirect) {
        imagesService.save(images);
        redirect.addFlashAttribute("message" ,"Sua thanh cong!");
        return "redirect:/images";
    }
    @GetMapping("/delete-images/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Images images = imagesService.findbyId(id);
        if(images != null) {
            ModelAndView modelAndView = new ModelAndView("images/delete");
            modelAndView.addObject("images", images);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-images")
    public String deleteProvince(@ModelAttribute("images") Images images){
        imagesService.remove(images.getId());
        return "redirect:images";
    }
}
