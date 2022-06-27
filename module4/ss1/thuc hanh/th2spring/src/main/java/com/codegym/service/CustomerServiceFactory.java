package com.codegym.service;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = (CustomerService) new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}

