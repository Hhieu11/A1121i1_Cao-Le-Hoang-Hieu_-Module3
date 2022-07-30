package com.codegym.demo.controller;

import com.codegym.demo.Valid.LoginValid;
import com.codegym.demo.entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @GetMapping("/")
    public  String index(Model model){
        model.addAttribute("login",new Login());

        return "index";
    }
    @PostMapping("/s")
    public String check(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model){
        LoginValid loginValid= new LoginValid();
        loginValid.validate(login,bindingResult);
        if(bindingResult.hasErrors()){
            return "index";
        }
        else {
        model.addAttribute("login",login);
        return "result";
        }
    }

}
