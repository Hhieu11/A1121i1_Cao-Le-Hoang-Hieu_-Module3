package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerServiceImpl {
    void save (Customer customer);
    List<Customer> display();
}
