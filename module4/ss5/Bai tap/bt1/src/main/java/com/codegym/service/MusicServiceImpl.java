package com.codegym.service;

import com.codegym.entity.Music;
import com.codegym.repository.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Transactional
@Service
public class MusicServiceImpl implements  MusicService {
    private MusicRepo musicRepo;
    @Autowired
    public MusicServiceImpl(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }

    public MusicServiceImpl() {

    }

    @Transactional
    @Override
    public void create(Music music) {
        musicRepo.create(music);

    }
    @Transactional
    @Override
    public void update(Music music) {
        musicRepo.update(music);

    }

    @Override
    public void delete(int id) {
        musicRepo.delete(id);

    }

    @Override
    public List<Music> findAll() {
        return musicRepo.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepo.findById(id);
    }
}
