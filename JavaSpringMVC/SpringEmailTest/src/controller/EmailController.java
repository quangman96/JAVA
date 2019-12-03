package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @GetMapping("/checkEmail")
    public String showIndex(){
        return "checkEmail";
    }
    @PostMapping ("/check")
    public String doCheckMail(@RequestParam("email") String email, Model model){
        return "checkEmail";
    }
}
