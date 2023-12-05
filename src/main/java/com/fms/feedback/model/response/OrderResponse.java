package com.fms.feedback.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderResponse {
    private float totalPrice;
    private Date orderDate;
    private String orderStatus;
    private String orderId;
}
