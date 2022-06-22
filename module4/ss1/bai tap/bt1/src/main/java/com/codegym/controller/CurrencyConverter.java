package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class CurrencyConverter {

    @GetMapping("/converter")
    public String getHello(){
        return "converter";
    }

    @PostMapping("/converter")
    public String converter(@RequestParam float rate, float usd, Model model){
        float vnd = rate * usd;
        model.addAttribute("rate",rate);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd", vnd);

        return "converter";
    }


}
