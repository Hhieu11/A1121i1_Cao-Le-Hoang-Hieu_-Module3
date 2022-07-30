package com.codegym.demo.service;

import com.codegym.demo.entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(Long id);
}
