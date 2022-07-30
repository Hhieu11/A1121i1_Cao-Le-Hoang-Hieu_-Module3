package com.codegym.demo.service;

import com.codegym.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    void remove(Long id);
    Customer save(Customer customer);
}
