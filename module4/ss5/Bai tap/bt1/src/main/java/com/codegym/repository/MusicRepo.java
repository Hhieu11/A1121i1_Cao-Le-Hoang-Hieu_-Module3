package com.codegym.repository;

import com.codegym.entity.Music;

import java.util.List;

public interface MusicRepo {
    void create(Music music);

    void update(Music music);

    void delete(int id);

    List<Music> findAll();

    Music findById(int id);

}

