package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository repository;

    @Override
    public void create(Blog blog) {
        repository.save(blog);

    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);

    }

    @Override
    public void delete(Integer id) {
    repository.deleteById(id);

    }

//    @Override
//    public List<Blog> findAll() {
//        return repository.findAll();
//    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return repository.findAllByNameContaining(name,pageable);
    }
// phan trang
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(String id, Pageable pageable) {
        return repository.findAllByCategory(id,pageable);
    }
}
