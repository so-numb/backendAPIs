package com.fms.feedback.controller;

import com.fms.feedback.model.Order;
import com.fms.feedback.model.request.OrderRequest;
import com.fms.feedback.model.response.OrderResponse;
import com.fms.feedback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderservice;

    @PostMapping("/create")
    OrderResponse createOrder(@RequestBody OrderRequest orderRequest){
        return orderservice.createOrder(orderRequest);
    }

    @GetMapping("/view_all")
    List<Order> viewAllOrder(){
        return orderservice.viewAllOrder();
    }

    @DeleteMapping("/delete_all")
    String deleteAllOrder(){
        return orderservice.deleteAllOrder();
    }
}
