package com.codegym.demo.service;

import com.codegym.demo.entity.Product;
import com.codegym.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository repository;

//
//    @Override
//    public Product findById(Long id) {
//        return repository.findById(id).orElse(null);
//    }


//    @Override
//    public Iterable<Product> findAll() {
//        return repository.findAll();
//    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();

    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
