package com.codegym.bt_blog.controller.RestController;

import com.codegym.bt_blog.entity.Blog;
import com.codegym.bt_blog.service.BlogService;
import com.codegym.bt_blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/blog/search")
    public ResponseEntity<List<Blog>> returnList(String name){
        List<Blog> list = blogService.queryBlogByName(name);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
