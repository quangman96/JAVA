package com.codegym.controller;


import com.codegym.model.DataType;
import com.codegym.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataTypeController {
    @Autowired
    private DataTypeService dataTypeService;
    @GetMapping("/list")
    public ModelAndView list(){
        Iterable<DataType> dataTypes = dataTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/datatype/list");
        return modelAndView;
    }

}
