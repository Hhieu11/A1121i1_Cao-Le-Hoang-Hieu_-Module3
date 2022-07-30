package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public String getList(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blog",blogList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        Blog blog= new Blog();
        model.addAttribute("blog", blog);
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/list";
    }

}
