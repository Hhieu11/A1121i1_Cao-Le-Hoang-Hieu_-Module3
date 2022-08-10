package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.CustomerType;
import com.codegym.casestudy.repository.CustomerRepository;
import com.codegym.casestudy.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeServiceImpl  implements CustomerTypeService{
    @Autowired
    private CustomerTypeRepository  customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
