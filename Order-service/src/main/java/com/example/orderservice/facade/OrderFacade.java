package com.example.orderservice.facade;

import com.example.orderservice.dto.OrderDtoGet;
import com.example.orderservice.dto.OrderDtoSave;

import java.util.List;

public interface OrderFacade {
    List<OrderDtoGet> getAllOrders();

    OrderDtoGet getOrderById(Long id);

    List<OrderDtoGet> getByProduceId(String id);

    List<OrderDtoGet> getByUserId(Long id);

    String saveOrder(OrderDtoSave orderDtoSave);

    void deleteById(Long id);
}
