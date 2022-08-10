package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where user_name=?1", nativeQuery = true)
    User findByUserName(String userName);
}
