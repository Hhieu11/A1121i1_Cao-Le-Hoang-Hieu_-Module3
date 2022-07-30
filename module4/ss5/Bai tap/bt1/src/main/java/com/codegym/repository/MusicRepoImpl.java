package com.codegym.repository;

import com.codegym.entity.Music;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
//@Transactional
public class MusicRepoImpl implements MusicRepo {

    @PersistenceContext
    public EntityManager entityManager;




    @Override
    public void create(Music music) {
        entityManager.persist(music);

    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);

    }

    @Override
    public void delete(int id) {
        Music music=findById(id);
        entityManager.remove(music);

    }

    @Override
    public List<Music> findAll() {
        //HQL
        List<Music> musicList=entityManager.createQuery("select m from Music m").getResultList();

        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return musicList ;
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }
}
