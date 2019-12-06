package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Caculator {
   @GetMapping ("/caculator")
    public String Caculator(){
       return "views";
   }
   @PostMapping("/result")
    public String Result(@RequestParam Float text1, Float text2, String operator, Model model){
       Float result;
       switch (operator){
           case "cong":
               result = text1 + text2;
               break;
           case "tru":
               result = text1 - text2;
               break;
           case "nhan":
               result = text1 * text2;
               break;
           case "chia":
               result = text1 / text2;
               break;
           default:
               throw new IllegalStateException("Unexpected value: " + operator);
       }
       model.addAttribute("result",result);
       return "views";
   }
}
