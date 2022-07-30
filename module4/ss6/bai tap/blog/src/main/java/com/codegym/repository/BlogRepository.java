package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
