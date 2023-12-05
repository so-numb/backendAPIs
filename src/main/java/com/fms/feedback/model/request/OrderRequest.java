package com.fms.feedback.model.request;

import com.fms.feedback.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private String phoneNumber;
    private List<OrderItem>orderItems;
    private String deliveryAddress;
}
