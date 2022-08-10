package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogForm;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CateloryService;
import groovy.transform.PackageScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CateloryService cateloryService;
    @Value("${file-upload}")
    private String fileUpload;
//    @GetMapping("list")
//    public String list(Model model){
//        List<Blog>blogList=blogService.findAll();
//        model.addAttribute("blog",blogList);
//        return "list";
//    }
//    @GetMapping("/create")
//    public String create(Model model){
//    Blog blog= new Blog();
//    model.addAttribute("blog",blog);
//    return"create";
//    }


    // phan trang


    @GetMapping("list")
    public String list(@PageableDefault(value =4) Pageable pageable, Model model){
        Page<Blog> blogList=blogService.findAll(pageable);
        model.addAttribute("blog",blogList);
        return "list";
    }

@GetMapping("/create")
public String create(Model model){
    List<Category> categoryList = cateloryService.findAll();
    BlogForm blog=new BlogForm();
    blog.setCategory(new Category());

    model.addAttribute("blog",blog);
    model.addAttribute("category", categoryList);
    return"create";
}


//    @PostMapping("/save")
//    public  String save(@ModelAttribute("blog") Blog blog){
//    blogService.create(blog);
    //    return  "redirect:/list";
//    }


    @PostMapping("/save")
    public String save(@ModelAttribute("blog") BlogForm blogForm) {
        MultipartFile multipartFile = blogForm.getImage();
        String path = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(fileUpload + path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = new Blog(blogForm.getId(), blogForm.getName(),path, blogForm.getContent(),blogForm.getCategory());
        blogService.create(blog);
        return "redirect:/list";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
    List<Category>categoryList=cateloryService.findAll();
    Blog blog=blogService.findById(id);
    model.addAttribute("blog",blog);
    model.addAttribute("category",categoryList);
    return "edit";
    }
    @PostMapping("/update")
    public  String update(@ModelAttribute("blog") Blog blog){
        blogService.update(blog);
        return "redirect:/list";

    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id,Model model){
        List<Category>categoryList=cateloryService.findAll();
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("category",categoryList);
        return "view";


    }

    @GetMapping("/delete/{id}")
    public  String detete(@PathVariable("id") Integer id){
    blogService.delete(id);
        return "redirect:/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name")String name,Model model,@PageableDefault(value =3) Pageable pageable){
    Page<Blog>blogList=blogService.search(name,pageable);
    model.addAttribute("blog",blogList);
    return"list";
    }
//    @GetMapping("/searchCate/{id}")
//    public String searchCate(@PathVariable("id") String id,@PageableDefault(value = 3) Pageable pageable,Model model){
//        Page<Blog>blogs=blogService.findAllByCategory(id,pageable);
//        List<Category>categoryList=cateloryService.findAll();
//        model.addAttribute("blog",blogs);
//        model.addAttribute("category",categoryList);
//        return "list";
//
//    }

}
