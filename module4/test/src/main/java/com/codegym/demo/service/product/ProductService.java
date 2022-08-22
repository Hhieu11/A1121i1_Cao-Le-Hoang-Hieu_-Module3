package com.codegym.demo.service;

import com.codegym.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.beans.Customizer;
import java.util.Optional;

public interface ProductService {
    void save(Product product);
    Page<Product> findAll(Pageable pageable);
    Optional<Product> findById(Integer id);
    void remove(Integer id);

    Page<Product>search(String name, String catelogyName, Pageable pageable);

    Page<Product>findAllByProductNameContaining(String name,Pageable pageable);

}


