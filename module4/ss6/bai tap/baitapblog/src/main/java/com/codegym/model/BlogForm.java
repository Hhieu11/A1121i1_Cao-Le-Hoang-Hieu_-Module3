package com.codegym.model;


import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Integer id;
    private String name;
    private MultipartFile image;
    private String content;
    private Category category;

    public BlogForm() {
    }

    public BlogForm(Integer id, String name, MultipartFile image, String content, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.content = content;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
