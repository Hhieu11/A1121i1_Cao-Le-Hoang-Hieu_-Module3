package com.codegym.bt_blog.service;

import com.codegym.bt_blog.entity.Category;
import com.codegym.bt_blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void create(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return null;
    }
}
