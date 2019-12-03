package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tygreeting")
public class GreetingController {
    @GetMapping("/123")
    public String greeting(){
        return "greeting1";
    }

}
