package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.repository.ProductRepo;
import com.codegym.repository.ProductRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements ProductServiceImpl {
    private ProductRepoImpl productRepo;
@Autowired
public ProductService(ProductRepoImpl productRepo){
    this.productRepo=productRepo;
}
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);

    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id,product);

    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);

    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }
}
