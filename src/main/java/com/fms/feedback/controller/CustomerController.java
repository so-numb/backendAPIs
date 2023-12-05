package com.fms.feedback.controller;

import com.fms.feedback.model.Customer;
import com.fms.feedback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    String registerUser(@RequestBody Customer customer){
        return customerService.registerUser(customer);
    }

    @GetMapping("/view_all")
    List<Customer> customerList(){
        return customerService.customerList();
    }
    @DeleteMapping("/delete_all")
    String deleteAllCustomer(){
        return customerService.deleteAllCustomer();
    }

}
