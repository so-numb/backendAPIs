package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("customer")
@Getter
@Setter
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String customerContact;
    private String customerAddress;
    private List<String> orderIds;
}
