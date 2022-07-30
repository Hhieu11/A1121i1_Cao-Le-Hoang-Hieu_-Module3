package com.codegym.demo.service;

import com.codegym.demo.entity.Music;
import com.codegym.demo.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepo musicRepo;
    @Override
    public List<Music> findAll() {
        return  musicRepo.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepo.save(music);

    }

    @Override
    public Music findById(Long id) {
        return musicRepo.findById(id).orElse(null);
    }
}
