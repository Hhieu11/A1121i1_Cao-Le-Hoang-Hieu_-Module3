package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void save(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAll();

    Optional<Customer> findById(String id);

    void remove(String id);

//    Iterable<Customer>search(String name);
//Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
    Page<Customer>search(String name,String address,String email,Pageable pageable);


}
