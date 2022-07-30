package com.codegym.repository;

import com.codegym.entity.Product;


import java.util.List;

public interface ProductRepoImpl {

    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void remove(int id);
    List<Product> findByName(String name);
}
