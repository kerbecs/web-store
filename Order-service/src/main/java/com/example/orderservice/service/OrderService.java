package com.example.orderservice.service;

import com.example.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(Long id);

    List<Order> getByProduceId(String id);

    List<Order> getByUserId(Long id);

    Order saveOrder(Order order);

    void deleteById(Long id);
}
