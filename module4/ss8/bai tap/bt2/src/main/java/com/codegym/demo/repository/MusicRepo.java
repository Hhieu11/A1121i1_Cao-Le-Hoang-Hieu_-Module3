package com.codegym.demo.repository;

import com.codegym.demo.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepo extends JpaRepository<Music,Long> {
}
