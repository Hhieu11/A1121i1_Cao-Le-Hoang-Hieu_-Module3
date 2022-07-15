package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Blog, Integer> {


}
