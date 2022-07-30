package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.CateloryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CateloryServiceImpl implements CateloryService {
    @Autowired
    CateloryRepository repository;
    @Override
    public void create(Category category) {
    repository.save(category);

    }

    @Override
    public void update(Category category) {
    repository.save(category);

    }

    @Override
    public void delete(String id) {
    repository.deleteById(id);

    }

    @Override
    public List<Category> findAll() {
        return  repository.findAll();
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
