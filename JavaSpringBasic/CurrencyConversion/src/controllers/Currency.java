package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Currency {
    @RequestMapping("/")
    public String currency(){
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    public String currencyMoney(@RequestParam("usd")double usd) {
        double vnd = usd * 23400;
        return "Currency conversion " + usd + " usd is " + " = " + vnd;
    }

}
