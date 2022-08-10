package com.codegym.casestudy.service;

import com.codegym.casestudy.entity.Customer;
import com.codegym.casestudy.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    void save(Employee employee);

    Page<Employee> findAll(Pageable pageable);

    Iterable<Employee> findAll();

    Optional<Employee> findById(Integer id);

    void remove(Integer id);
    Iterable<Employee>search(String name);
}
