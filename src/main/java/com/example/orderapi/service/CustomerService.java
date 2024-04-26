package com.example.orderapi.service;

import com.example.orderapi.entity.Customer;
import com.example.orderapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer editCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getCustomerId());
        if (existingCustomer.isPresent()) {
            customer.setCustomerId(existingCustomer.get().getCustomerId()); // Keep original ID
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer with ID " + customer.getCustomerId() + " not found");
        }
    }

    public Customer editCustomer(int customerId, Customer editedCustomer) {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setCustomerName(editedCustomer.getCustomerName());
                    customer.setAddress(editedCustomer.getAddress());
                    customer.setPhoneNumber(editedCustomer.getPhoneNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
