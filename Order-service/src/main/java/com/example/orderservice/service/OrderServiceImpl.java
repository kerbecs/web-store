package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.NoSuchElementException;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order with id " + id + " does not exists"));
    }

    @Override
    public List<Order> getByProduceId(String id) {
        return orderRepository.findByProduceId(id);
    }

    @Override
    public List<Order> getByUserId(Long id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
