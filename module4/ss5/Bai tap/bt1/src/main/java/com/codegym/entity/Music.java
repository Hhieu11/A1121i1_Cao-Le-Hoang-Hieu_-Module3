package com.codegym.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @Column(name = "music_id", columnDefinition = "varchar(10)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String artist;
    private String genre ;
    private String path;

    public Music() {
    }

    public Music(int id, String name, String artist, String genre, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
