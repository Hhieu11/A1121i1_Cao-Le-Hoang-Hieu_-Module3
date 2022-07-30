package com.codegym.repository;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerRepo {
    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    List<Customer> findAll();

    Customer findById(String id);
}
