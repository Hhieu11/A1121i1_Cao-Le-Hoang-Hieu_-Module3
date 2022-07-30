package com.codegym.demo.service;

import com.codegym.demo.entity.Product;
import com.codegym.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl  implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        productRepo.deleteById(id);

    }
}
