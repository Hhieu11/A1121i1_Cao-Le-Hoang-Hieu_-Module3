package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.User;
import com.codegym.casestudy.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(User user);
}