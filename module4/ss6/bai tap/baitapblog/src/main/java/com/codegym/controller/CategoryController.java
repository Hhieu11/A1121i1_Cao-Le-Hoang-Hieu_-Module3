package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CateloryService cateloryService;

    @GetMapping("/category")
    public String list(Model model){
    List<Category> categoryList=cateloryService.findAll();
    model.addAttribute("category",categoryList);
    return "listCate";
    }

    @GetMapping("/createCate")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return ("createCate");
    }
    @PostMapping("/saveCate")
    public String save(@ModelAttribute("category") Category category){
        cateloryService.create(category);
        return "redirect:/category";
    }


    @GetMapping("/updateCate/{id}")
    public String update(@PathVariable("id") String id,Model model){
        Category categoryList =cateloryService.findById(id);
        model.addAttribute("category",categoryList);
        return "categoryEdit";
    }
    @PostMapping("/editCate")
    public String edit(@ModelAttribute("category") Category category){
        cateloryService.update(category);
        return "redirect:/category";
    }
    @GetMapping("/deleteCate/{id}")
    public  String detete(@PathVariable("id") String id){
        cateloryService.delete(id);
        return "redirect:/category";
    }

}
