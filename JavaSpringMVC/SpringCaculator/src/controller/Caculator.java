package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class Caculator {
    @RequestMapping(value = "/caculator",method = POST)
    public String showForm() {
        return "caculator";
    }
    @RequestMapping(value = "/caculate", method = POST)
    public String caculate(@RequestParam("value1") Integer value1,
                           @RequestParam("value2") Integer value2,
                           @RequestParam("operator") String operator,
                           ModelMap model){
        int outPutDefault = 0;
        int firstValue = value1;
        int secondValue = value2;
        model.addAttribute("firstValue",firstValue);
        model.addAttribute("secondValue",secondValue);

    }
}
