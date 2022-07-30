package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
//    List<Blog> findAll();
    Blog findById(Integer id);
    Page<Blog> search(String name, Pageable pageable);

    //phan trang
    Page<Blog> findAll(Pageable pageable);
    Page<Blog>findAllByCategory(String id,Pageable pageable);

}
