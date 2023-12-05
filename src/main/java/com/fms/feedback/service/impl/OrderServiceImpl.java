package com.fms.feedback.service.impl;

import com.fms.feedback.model.Customer;
import com.fms.feedback.model.Order;
import com.fms.feedback.model.OrderItem;
import com.fms.feedback.model.request.OrderRequest;
import com.fms.feedback.model.response.OrderResponse;
import com.fms.feedback.repository.CustomerRepository;
import com.fms.feedback.repository.OrderRepository;
import com.fms.feedback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findByCustomerContact(orderRequest.getPhoneNumber());

        Order order = new Order();

        order.setCustomerId(customer.getCustomerId());
        order.setItemList(orderRequest.getOrderItems());
        float sum = 0;
        for(OrderItem orderItem : orderRequest.getOrderItems()){
            sum = sum + (orderItem.getPricePerUnit()*orderItem.getUnit());
        }
        order.setTotalPrice(sum);
        order.setOrderDate(new Date());
        order.setOrderStatus("Order Placed!");
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());

        order = orderRepository.save(order);

        customer.getOrderIds().add(order.getOrderId());
        customerRepository.save(customer);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getOrderId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setOrderStatus(order.getOrderStatus());
        orderResponse.setTotalPrice(order.getTotalPrice());

        return orderResponse;
    }

    @Override
    public List<Order> viewAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public String deleteAllOrder() {
        orderRepository.deleteAll();
        return "Deleted";
    }

}
