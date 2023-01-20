package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseCustomer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Page<Customer> findPaginated(int currentPage, int size);
    List<Customer> findCustomers();
    Optional<Customer> getById(Long id);
    Customer saveCustomer(RequestCreateCustomer request);

    Optional<Customer> getCustomerById(Long id);
    void updateCustomer(Long id, RequestUpdateCustomer request);
    /**
    CustomerDTO findCustomer(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    ResponseCustomer updateCustomer(RequestUpdateCustomerDTO customerDTO);

    Boolean deleteCustomer(Long id);
     */
}
