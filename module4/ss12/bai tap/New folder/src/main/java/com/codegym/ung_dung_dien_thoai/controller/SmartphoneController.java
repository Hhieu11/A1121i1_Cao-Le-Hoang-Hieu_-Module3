package com.codegym.ung_dung_dien_thoai.controller;

import com.codegym.ung_dung_dien_thoai.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("smartphones",smartphoneService.findAll());
        return "list";
    }
}
