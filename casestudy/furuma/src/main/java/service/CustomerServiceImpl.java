package service;

import model.Customer;
import repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository= new CustomerRepository();
    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }

    @Override
    public Customer getIdCustomer(int id) {
        return null;
    }

    @Override
    public int getIdMax() {
        return 0;
    }

    @Override
    public void addCustomerList(Customer customer) {

    }

    @Override
    public void updateCustomerId(Customer customer, int id) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}
