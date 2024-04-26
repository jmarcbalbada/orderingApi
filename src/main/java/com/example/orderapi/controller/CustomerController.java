package com.example.orderapi.controller;

import com.example.orderapi.entity.Customer;
import com.example.orderapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

//    @PutMapping("/{customerId}")
//    public Customer editCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
//        customer.setCustomerId(customerId); // Ensure ID remains the same
//        return customerService.editCustomer(customer);
//    }

    @PutMapping("/{customerId}")
    public Customer editCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
//        customer.setCustomerId(customerId); // Ensure ID remains the same
        return customerService.editCustomer(customerId, customer);
    }
//
//    @DeleteMapping("/{customerId}")
//    public void deleteCustomer(@PathVariable int customerId) {
//        customerService.deleteCustomer(customerId);
//    }

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
