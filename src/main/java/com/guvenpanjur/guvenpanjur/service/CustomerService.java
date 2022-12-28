package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseCustomer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> findCustomers();
    ResponseCustomer saveCustomer(ResponseCustomer customer);
    RequestCreateCustomer getById(Long id);
    /**
    CustomerDTO findCustomer(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    ResponseCustomer updateCustomer(RequestUpdateCustomerDTO customerDTO);

    Boolean deleteCustomer(Long id);
     */
}
