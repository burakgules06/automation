package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateCustomer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    List<Customer> findCustomers();
    Optional<Customer> getById(Long id);
    Customer saveCustomer(RequestCreateCustomer request);
    /**
    CustomerDTO findCustomer(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    ResponseCustomer updateCustomer(RequestUpdateCustomerDTO customerDTO);

    Boolean deleteCustomer(Long id);
     */
}
