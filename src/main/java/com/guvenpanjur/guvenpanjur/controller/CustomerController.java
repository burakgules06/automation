package com.guvenpanjur.guvenpanjur.controller;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("customer", new Customer());
        return "create_customer";
    }
    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer,
                               RedirectAttributes redirectAttributes){
        customer=customerService.saveCustomer(customer);
        redirectAttributes.addAttribute("customerId",customer.getCustomerId());
        return "redirect:/offers/new";

    }

    @GetMapping("/test1")
    public ModelAndView test(RedirectAttributes redirectAttributes){
        ModelAndView modelAndView=new ModelAndView("redirect:/test2");
        redirectAttributes.addAttribute("id","DENEME");
        return modelAndView;
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
