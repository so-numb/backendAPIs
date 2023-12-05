package com.fms.feedback.repository;

import com.fms.feedback.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByCustomerContact(String phoneNumber);
}
