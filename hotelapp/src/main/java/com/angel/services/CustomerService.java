package com.angel.services;

import java.util.Optional;

import com.angel.entities.Customer;

public interface CustomerService {
    Optional<Customer> getCustomerByEmail(String email);
    Customer updateCustomer(Long id, Customer customerDetails);
    Optional<Customer> getCustomerById(Long id);
}
