package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.repository.CustomerRepository;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService
{
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(Customer.builder().customerId(100L).build());
    }


    /**
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer1 = modelMapper.map(customerDTO, Customer.class);
        return modelMapper.map(customerRepository.save(customer1), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> findCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> dtos = customers.stream().map(customer -> modelMapper.map(customer,CustomerDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public CustomerDTO findCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return modelMapper.map(customer.get(), CustomerDTO.class);
        }
        throw new IllegalArgumentException("Müşteri Bulunamadı");
    }

    @Override
    public ResponseCustomer updateCustomer(RequestUpdateCustomerDTO request) {
        customerRepository
                .findById(request.getId()).orElseThrow(()->new RuntimeException("Customer yok!!"));
        var newAddress=addressRepository.findById(request.getAddressId()).orElseThrow(()->new RuntimeException("Adres yok!!"));
        var customer=modelMapper.map(request,Customer.class);
        customer.setAddress(newAddress);
        customerRepository.save(customer);
        var response=modelMapper.map(customer,ResponseCustomer.class);
        response.setAddress(modelMapper.map(newAddress, ResponseAddress.class));
        return response;
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    */
}
