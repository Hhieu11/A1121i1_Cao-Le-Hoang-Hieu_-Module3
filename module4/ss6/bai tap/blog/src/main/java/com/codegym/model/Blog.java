package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String title;
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String image, String title, String content) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
    }

    public Blog(String image, String title, String content) {
        this.image = image;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
