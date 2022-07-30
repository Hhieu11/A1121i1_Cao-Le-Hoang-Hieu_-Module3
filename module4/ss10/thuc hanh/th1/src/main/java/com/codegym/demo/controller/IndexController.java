package com.codegym.demo.controller;

import com.codegym.demo.entity.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class IndexController {
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("/")
    public  String index(@ModelAttribute("counter") Counter counter){
        counter.increment();
        return "index";
    }
}
