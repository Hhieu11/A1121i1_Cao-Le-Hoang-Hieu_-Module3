package com.codegym.demo.controller;

import com.codegym.demo.entity.Phone;
import com.codegym.demo.validate.PhoneValid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ValidController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "index";
    }
    @PostMapping("/")
    public String check(@Valid @ModelAttribute("phone") Phone phone, BindingResult bindingResult,Model model){
        PhoneValid phoneValid = new PhoneValid();
        phoneValid.validate(phone,bindingResult);
        if(bindingResult.hasErrors()){
            return "index";
        }
        else {
            model.addAttribute("phone",phone);
            return "result";
        }
    }
}
