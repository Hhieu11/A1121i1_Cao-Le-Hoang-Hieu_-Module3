package model.service.Impl;

import model.bean.Product;
import model.repository.Impl.ProductRepoImpl;
import model.repository.ProductRepo;
import model.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepo productRepo= new ProductRepoImpl();


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
}
