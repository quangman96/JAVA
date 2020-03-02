package com.codegym.controller;

import com.codegym.model.Department;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/listDepartment")
    public ModelAndView list(){
        Iterable<Department> departments =departmentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/department/list");
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }
    @GetMapping("/createDepartment")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/department/create");
        modelAndView.addObject("department",new Department());
        return modelAndView;
    }
    @PostMapping("/createDepartment")
    public ModelAndView create(@ModelAttribute("department") Department department){
        ModelAndView modelAndView = new ModelAndView("/department/create");
       departmentService.save(department);
        modelAndView.addObject("department",new Department());
        return modelAndView;
    }
}
