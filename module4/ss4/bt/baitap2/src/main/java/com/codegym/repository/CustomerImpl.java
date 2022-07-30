package com.codegym.repository;

import com.codegym.model.Customer;


import java.util.List;

public interface CustomerImpl {
    void save (Customer customer);
    List<Customer> display();
}
