package com.codegym.bt_blog.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    @ManyToOne()
    @JoinColumn(name = "categoryCode", referencedColumnName = "categoryCode")
    private Category category;
    private String image;

    public Blog() {
    }

    public Blog(Integer id, String name, String image, String content, Category category) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
