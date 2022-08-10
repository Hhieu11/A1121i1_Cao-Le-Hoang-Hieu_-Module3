package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.CustomerType;

public interface CustomerTypeService {
    Iterable<CustomerType> findAll();
}
