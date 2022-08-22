package com.codegym.demo.service;

import com.codegym.demo.entity.Product;
import com.codegym.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
    productRepository.deleteById(id);
    }

    @Override
    public Page<Product> search(String name, String catelogyName, Pageable pageable) {
        return productRepository.findAllByProductNameContainingAndCatelogy_CatelogyName(name, catelogyName, pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(name, pageable);
    }
}
