package com.codegym.bt_blog.controller;

import com.codegym.bt_blog.entity.Blog;
import com.codegym.bt_blog.entity.Category;
import com.codegym.bt_blog.service.BlogService;
import com.codegym.bt_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public String list(@PageableDefault (value = 3)Pageable pageable, Model model){
        Page<Blog> blogPage=blogService.findAll(pageable);
        model.addAttribute("blog",blogPage);

        return "listBlog";
    }
    @GetMapping("/create")
    public String create(Model model){
        List<Category>categoryList=categoryService.findAll();
        Blog blog= new Blog();
        blog.setCategory(new Category());
        model.addAttribute("blog",blog);
        model.addAttribute("category",categoryList);
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog){
        blogService.create(blog);
        return  "redirect:/list";
    }
}
