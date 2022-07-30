package com.codegym.bt_blog.service;

import com.codegym.bt_blog.entity.Blog;
import com.codegym.bt_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);


    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);

    }

//    @Override
//    public Blog findById(Integer id) {
//        return null;
//    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(String id, Pageable pageable) {
        return null;
    }

    @Override
    public List<Blog> queryBlogByName(String name) {
        return blogRepository.queryBlogByName(name);
    }
}
