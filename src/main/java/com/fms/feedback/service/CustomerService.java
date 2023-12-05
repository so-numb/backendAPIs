package com.fms.feedback.service;

import com.fms.feedback.model.Customer;

import java.util.List;

public interface CustomerService {
    String registerUser(Customer customer);

    List<Customer> customerList();

    String deleteAllCustomer();
}
