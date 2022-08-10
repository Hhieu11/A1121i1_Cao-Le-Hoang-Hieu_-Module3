package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
//
//    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    Page<Customer>findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerEmailContaining(String name,String address,String email,Pageable pageable);


//    @Query("select c from Customer as c where c.customerName like %?1% and c.customerAddress like %?2% and c.customerEmail like %?3%")
//    Page<Customer> search(String name,String address, String email, Pageable pageable);
}
