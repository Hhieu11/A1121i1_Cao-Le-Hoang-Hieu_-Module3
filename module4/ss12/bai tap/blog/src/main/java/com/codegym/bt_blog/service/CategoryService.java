package com.codegym.bt_blog.service;

import com.codegym.bt_blog.entity.Blog;
import com.codegym.bt_blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    void create(Category category);
    void update(Category category);
    void delete(String id);
    List<Category> findAll();
    Category findById(String id);
}
