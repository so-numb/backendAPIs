package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("order")
@Getter
@Setter
public class Order {
    @Id
    private String orderId;
    private List<OrderItem> itemList;
    private float totalPrice;
    private String customerId;
    private String orderStatus;
    private Date orderDate;
    private String deliveryAddress;
}
