package com.codegym.demo.service;

import com.codegym.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void remove(Long id);
}
