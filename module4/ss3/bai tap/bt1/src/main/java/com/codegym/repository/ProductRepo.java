package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@EnableTransactionManagement
public class ProductRepo implements ProductRepoImpl  {
    @PersistenceContext
    EntityManager entityManager;


//    private static final Map<Integer, Product> products;
//    static{
//
//        products = new HashMap<>();
//        products.put(1,new Product(1,"IPHONE", "1000000", "SANG TRONG","APPLE"));
//        products.put(2,new Product(2,"MI 12", "1900000", "DEP","XIAOMI"));
//        products.put(3,new Product(3,"SAMSUNG NOTE 22", "2000000", "DEP","SAMSUNG"));
//        products.put(4,new Product(4,"IPHONE", "1000000", "SANG TRONG","APPLE"));
//    }persist


    @Override
    public List<Product> findAll() {
        // HQL
        List<Product> products = entityManager
                .createQuery("select p from Product p",Product.class)
                .getResultList();
        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return products;
    }

    @Override
    @Modifying
    public void save(Product product) {
        entityManager.persist(product);

    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);

    }

    @Override
    public void remove(int id) {
        Product product=findById(id);
entityManager.remove(product);

    }

    @Override
    public List<Product> findByName(String name) {
        String query = "SELECT p FROM Product as p WHERE p.name =:name";
        TypedQuery<Product> product = entityManager.createQuery(query,Product.class);
        product.setParameter("name",name);

        return (List<Product>) product.getSingleResult();
    }

//    @Override
//    public List<Product> findByName(String name) {
//        List<Product> productList=new ArrayList<>(products.values());
//        for(Product product:productList){
//            if(product.getName().equals(name)){
//                productList.add(product);
//            }
//        }
//        return  productList;
//    }
}
