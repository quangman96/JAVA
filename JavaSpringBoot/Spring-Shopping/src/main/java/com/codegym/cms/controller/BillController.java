package com.codegym.cms.controller;

import com.codegym.cms.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.codegym.cms")
@RestController
public class BillController {
    @Autowired
    private BillService billService;

}
