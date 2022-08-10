package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerRepository customerRepository;
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);

    }

//    @Override
//    public Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable) {
//        return customerRepository.findAllByCustomerNameContaining(name,pageable);
//    }

    @Override
    public Page<Customer> search(String name, String address, String email, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerEmailContaining(name, address, email, pageable);
    }

//    @Override
//    public Page<Customer> search(String name, String address, String email, Pageable pageable) {
//        return customerRepository.search(name, address, email, pageable);
//    }

//    @Override
//    public Iterable<Customer> search(String name) {
//        return customerRepository.findAllByCustomerNameContaining(name);
//    }
}
