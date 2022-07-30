package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerImpl;
import com.codegym.repository.CustomerRepo;

import java.util.List;

public class CustomerService implements CustomerServiceImpl {
private CustomerImpl customerImpl=new CustomerRepo();
    @Override
    public void save(Customer customer) {
        customerImpl.save(customer);
    }

    @Override
    public List<Customer> display() {
        return customerImpl.display();
    }
}
