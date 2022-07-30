package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepo;
import com.codegym.repository.CustomerRepoImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements CustomerServiceImpl {
    private CustomerRepoImpl customerRepo=new CustomerRepo();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);


    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id,customer);

    }

    @Override
    public void remove(int id) {
        customerRepo.remove(id);

    }
}
