package model.repository.Impl;

import model.bean.Product;
import model.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements ProductRepo {
    public static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone","17000000","Dep","Apple"));
        productList.add(new Product(2,"SamSung","15000000","vip","SamSung"));
        productList.add(new Product(3,"K305G","7000000","Ben","Xiaomi"));
        productList.add(new Product(4,"Reno5","9000000","Dep","Oppo"));
        productList.add(new Product(7,"Xperia","6000000","Dep","Sony"));

    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);

    }

    @Override
    public Product findById(int id) {
        for(int i = 0;i<productList.size();i++) {
            if(id==(productList.get(i).getId())) {
                return productList.get(i);
            }
        }
        return null;
    }


    @Override
    public void update(int id, Product product) {
        for(int i = 0;i<productList.size();i++) {
            if(id==(productList.get(i).getId())) {
                productList.set(i,product);
            }
        }



    }

    @Override
    public void remove(int id) {
        for(int i = 0;i<productList.size();i++) {
            if(id==(productList.get(i).getId())) {
                productList.remove(i);
            }
        }

    }
}
