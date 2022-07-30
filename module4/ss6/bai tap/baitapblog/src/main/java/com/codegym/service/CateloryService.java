package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;

import java.util.List;

public interface CateloryService {
    void create(Category category);
    void update(Category category);
    void delete(String id);
    List<Category> findAll();
    Category findById(String id);
}
