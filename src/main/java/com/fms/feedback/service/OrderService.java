package com.fms.feedback.service;

import com.fms.feedback.model.Order;
import com.fms.feedback.model.request.OrderRequest;
import com.fms.feedback.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    List<Order> viewAllOrder();

    String deleteAllOrder();
}
