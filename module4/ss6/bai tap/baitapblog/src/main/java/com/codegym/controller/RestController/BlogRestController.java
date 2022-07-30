package com.codegym.controller.RestController;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    BlogService blogService;
    @Autowired
    CateloryService cateloryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>>showCate(){
        List<Category>categoryList=cateloryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }
    @GetMapping("/blog")
        public ResponseEntity<List<Blog>>showBlog(@PageableDefault (value = 3) Pageable pageable){
        List<Blog>blogList= (List<Blog>) blogService.findAll(pageable);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(blogList,HttpStatus.OK);
        }
        }

        //tim theo id
    @GetMapping("/category/{id}")
    public ResponseEntity<Category>findByIdCate(@PathVariable String id){
        Category category=cateloryService.findById(id);
        if(category!=null){
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> showBlogById(@PathVariable Integer id){
        Blog blog=blogService.findById(id);
        if(blog!=null){
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
