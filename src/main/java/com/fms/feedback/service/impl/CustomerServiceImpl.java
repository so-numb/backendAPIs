package com.fms.feedback.service.impl;

import com.fms.feedback.model.Customer;
import com.fms.feedback.repository.CustomerRepository;
import com.fms.feedback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String registerUser(Customer customer) {
        customerRepository.save(customer);
        return "Registered Successfully"+"\nYour customer ID is "+customer.getCustomerId();
    }

    @Override
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteAllCustomer() {
        customerRepository.deleteAll();
        return "Deleted";
    }
}
