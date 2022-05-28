package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

}
