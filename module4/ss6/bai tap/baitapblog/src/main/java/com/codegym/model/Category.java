package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @Column(length = 20)
    private String categoryCode;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Blog> blogs;

    public Category() {
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
