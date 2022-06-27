package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Caculator {
    @GetMapping("h")
    public  String home(){
        return "caculator";
    }

    @PostMapping("caculator")
    public String caculator(@RequestParam String first, String second, String ope, Model model){
        double f=Double.parseDouble(first);
        double s=Double.parseDouble(second);
        double result=0;

        if(ope.equals("+")){
            result=f+s;
        }
        else if(ope.equals("-")){
            result =f-s;
        }
        else if(ope.equals("*")){
            result=f*s;
        }
        else {
            result=f/s;
        }
        model.addAttribute("result",result);

        return "caculator";


    }

}
