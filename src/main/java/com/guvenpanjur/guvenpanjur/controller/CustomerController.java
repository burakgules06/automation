package com.guvenpanjur.guvenpanjur.controller;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateCustomer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.viewmodel.CreateCustomerViewModel;
import com.guvenpanjur.guvenpanjur.repository.CustomerRepository;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String listCustomers(ModelMap model){
       model.addAttribute("customers", customerService.findCustomers());
       return "customers";
    }
    @GetMapping("/customers/new")
    public String createCustomer(Model model){
        CreateCustomerViewModel customerViewModel = new CreateCustomerViewModel();
        model.addAttribute("customerViewModel", customerViewModel);
        return "create_customer";
    }
    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customerViewModel") CreateCustomerViewModel customer, RedirectAttributes redirectAttributes){

        RequestCreateCustomer createCustomer = new RequestCreateCustomer();
        createCustomer.setCustomerName(customer.getCustomerName());
        createCustomer.setCustomerLastName(customer.getCustomerLastName());
        createCustomer.setCustomerTelNo(customer.getCustomerTelNo());
        createCustomer.setCustomerCity(customer.getCustomerCity());
        createCustomer.setCustomerDistrict(customer.getCustomerDistrict());
        createCustomer.setCustomerNeighbourhood(customer.getCustomerNeighbourhood());
        createCustomer.setCustomerStreet(customer.getCustomerStreet());
        createCustomer.setCustomerBuildingNo(customer.getCustomerBuildingNo());
        createCustomer.setCustomerNo(customer.getCustomerNo());
        Customer savedCustomer =  customerService.saveCustomer(createCustomer);
        createCustomer.setCustomerId(savedCustomer.getCustomerId());

        redirectAttributes.addAttribute("customerId", createCustomer.getCustomerId());
        return "redirect:/offers/new";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomer(Model model, @PathVariable("id") Long id){
        Optional<Customer> customer = customerService.getById(id);
        model.addAttribute("editCustomer", customer);
        return "customer_edit";
    }
    @PostMapping("/customers/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @Validated RequestUpdateCustomer request, BindingResult result, Model model){
        if(result.hasErrors()){
            request.setCustomerId(id);
            return "customer_edit";
        }
        customerService.updateCustomer(id,request);
        model.addAttribute("editCustomer", customerService.findCustomers());
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
