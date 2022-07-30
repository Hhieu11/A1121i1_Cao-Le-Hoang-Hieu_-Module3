package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo= customerRepo;
    }
    @Override
    public void create(Customer customer) {
        customerRepo.create(customer);


    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);

    }

    @Override
    public void delete(String id) {
        customerRepo.delete(id);

    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id);
    }
}
