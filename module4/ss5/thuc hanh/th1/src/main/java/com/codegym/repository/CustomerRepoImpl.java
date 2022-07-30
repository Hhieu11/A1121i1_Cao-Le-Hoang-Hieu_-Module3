package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//@Transactional
//@EnableTransactionManagement

public class CustomerRepoImpl implements CustomerRepo {

    @PersistenceContext
    public EntityManager entityManager;
    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);

    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);

    }

    @Override
    public void delete(String id) {
        Customer customer=findById(id);
        entityManager.remove(customer);

    }

    @Override
    public List<Customer> findAll() {
        //HQL
        List<Customer> customerList=entityManager.createQuery("select c from Customer c").getResultList();

        // Native SQL
//        students = entityManager
//                .createNativeQuery("select * from Student")
//                .getResultList();
        return customerList;
    }

    @Override
    public Customer findById(String id) {
        return entityManager.find(Customer.class,id);
    }
}
