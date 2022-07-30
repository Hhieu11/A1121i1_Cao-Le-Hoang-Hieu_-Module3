package com.codegym.bt_blog.service;

import com.codegym.bt_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
    //    List<Blog> findAll();
//    Blog findById(Integer id);
    Page<Blog> search(String name, Pageable pageable);
    Optional<Blog> findById(Integer id);

    //phan trang
    Page<Blog> findAll(Pageable pageable);
    Page<Blog>findAllByCategory(String id,Pageable pageable);
    List<Blog> queryBlogByName(String name);
}
