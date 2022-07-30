package com.codegym.entity;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;
    private String name;
    private String artist;
    private String genre ;
    private MultipartFile path;

    public MusicForm() {
    }

    public MusicForm(int id, String name, String artist, String genre, MultipartFile path) {
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

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
