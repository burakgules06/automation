package com.guvenpanjur.guvenpanjur.controller;

import com.guvenpanjur.guvenpanjur.model.dto.CustomerDTO;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateCustomerDTO;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model){
       model.addAttribute("customers", customerService.findCustomers());
       return "customers";
    }
    @GetMapping("/customers/new")
    public String createCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }
    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";

    }



    /**
     @PostMapping("/create")
     public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
     CustomerDTO resultCustomer = customerService.createCustomer(customerDTO);
     return ResponseEntity.ok(resultCustomer);
     }
     @GetMapping("/findAll")
     public ResponseEntity<List<CustomerDTO>> findCustomers(){
     List<CustomerDTO> customers = customerService.findCustomers();
     return ResponseEntity.ok(customers);
     }
     @GetMapping("/findCustomer/{id}")
     public ResponseEntity<CustomerDTO> findCustomer(@PathVariable("id") Long id){
     CustomerDTO customerDTO = customerService.findCustomer(id);
     return ResponseEntity.ok(customerDTO);
     }
     @PutMapping()
     public ResponseEntity<?> updateCustomer( @RequestBody RequestUpdateCustomerDTO customerDTO){
     return ResponseEntity.ok(customerService.updateCustomer(customerDTO));
     }
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id){
     return ResponseEntity.ok(customerService.deleteCustomer(id));
     }

     */

}
