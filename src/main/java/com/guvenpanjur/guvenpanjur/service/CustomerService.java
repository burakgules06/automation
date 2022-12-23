package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> findCustomers();
    Customer saveCustomer(Customer customer);
    /**
    CustomerDTO findCustomer(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    ResponseCustomer updateCustomer(RequestUpdateCustomerDTO customerDTO);

    Boolean deleteCustomer(Long id);
     */
}
