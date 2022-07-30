package com.codegym.bt_blog.repository;

import com.codegym.bt_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface BlogRepository  extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from Subject where teacher like ?", nativeQuery = true)
    List<Blog> queryBlogByName(String name);


}
