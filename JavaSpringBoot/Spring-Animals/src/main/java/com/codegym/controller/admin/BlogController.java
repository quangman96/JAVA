package com.codegym.controller.admin;

import com.codegym.model.*;
import com.codegym.service.BlogService;
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
public class BlogController {
    private static String UPLOADED_FOLDER = "D:\\Bootcamp-JAVA-Backend\\JavaSpringBoot\\Spring-Animals\\src\\main\\resources\\static\\images\\";

    @Autowired
    private BlogService blogService;

    @GetMapping("/list-blog")
    public ModelAndView blogList() {
        Iterable<Blog> blog = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/admin/blog/list");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }


    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(@ModelAttribute("blogUpload") BlogUpload blogUpload) {
        ModelAndView modelAndView = new ModelAndView("/admin/blog/create");
        modelAndView.addObject("blogUpload", new BlogUpload());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView addBlog(@ModelAttribute("blogUpload") BlogUpload blogUpload,
                                   @RequestParam("file") MultipartFile file
    ) throws IOException {
        ModelAndView modelAndView = new ModelAndView("/admin/blog/create");

        if(file.isEmpty()){
            modelAndView.addObject("message", "Failed To Create New Blog");
            return modelAndView;
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path,bytes);

            Blog blog = new Blog();
            blog.setName(blogUpload.getName());
            blog.setDescription(blogUpload.getDescription());
            blog.setContent(blogUpload.getContent());
            blog.setImage(file.getOriginalFilename());
            blogService.save(blog);

        } catch (IOException e){
            e.printStackTrace();
        }
        modelAndView.addObject("blogUpload", new BlogUpload());
        modelAndView.addObject("message", "New Blog Was Created");
        return modelAndView;
    }
}
