package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);
    Page<Blog>findAllByCategory(String id,Pageable pageable);
}
