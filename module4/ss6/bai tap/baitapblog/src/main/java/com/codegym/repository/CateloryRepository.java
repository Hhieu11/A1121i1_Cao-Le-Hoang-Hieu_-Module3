package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CateloryRepository extends JpaRepository<Category, String> {
}
