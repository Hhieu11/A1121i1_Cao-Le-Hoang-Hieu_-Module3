package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements CustomerImpl {
    private  static List<Customer> customerList=new ArrayList<>();


    @Override
    public void save(Customer customer) {
        customerList.add(customer);

    }

    @Override
    public List<Customer> display() {
        return customerList;
    }
}
