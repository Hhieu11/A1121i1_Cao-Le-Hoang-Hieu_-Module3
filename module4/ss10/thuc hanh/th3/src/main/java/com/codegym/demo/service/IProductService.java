package com.codegym.demo.service;

import com.codegym.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
//    List<Product> findALl();
//    Product findById(Long id);
    List<Product> findAll();
    Optional<Product> findById(Long id);

}
