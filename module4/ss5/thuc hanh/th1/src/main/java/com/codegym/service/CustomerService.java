package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {
    void create(Customer customer);

    void update(Customer customer);

    void delete(String id);

    List<Customer> findAll();

    Customer findById(String id);

}
