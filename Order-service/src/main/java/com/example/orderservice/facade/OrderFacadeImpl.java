package com.example.orderservice.facade;

import com.example.orderservice.controller.OrderController;
import com.example.orderservice.dto.OrderDtoGet;
import com.example.orderservice.dto.OrderDtoSave;
import com.example.orderservice.dto.ProduceDto;
import com.example.orderservice.dto.UserDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.feign.ProduceFeign;
import com.example.orderservice.feign.UserFeign;
import com.example.orderservice.mapstruct.OrderMapper;
import com.example.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class OrderFacadeImpl implements OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final UserFeign userFeign;
    private final ProduceFeign produceFeign;

    @Override
    @CircuitBreaker(name = "orders")
    @Retry(name = "orders")
    public List<OrderDtoGet> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        return getUserAndProduceFromFeignClients(orders);
    }

    @Override
    @CircuitBreaker(name = "orders")
    @Retry(name = "orders")
    public OrderDtoGet getOrderById(Long id) {
        Order order = orderService.getOrderById(id);

        UserDto user = userFeign.getUserById(order.getUserId());
        ProduceDto produce = produceFeign.getById(order.getProduceId());

        return orderMapper.orderToOrderDtoGet(order, user, produce);

    }

    @Override
    @CircuitBreaker(name = "orders")
    @Retry(name = "orders")
    public List<OrderDtoGet> getByProduceId(String id) {
        List<Order> orders = orderService.getByProduceId(id);

        return getUserAndProduceFromFeignClients(orders);
    }

    @Override
    @CircuitBreaker(name = "orders")
    @Retry(name = "orders")
    public List<OrderDtoGet> getByUserId(Long id) {
        List<Order> orders = orderService.getByUserId(id);

        return getUserAndProduceFromFeignClients(orders);
    }

    @Override
    @CircuitBreaker(name = "orders")
    @Retry(name = "orders")
    public String saveOrder(OrderDtoSave orderDtoSave) {
        return "success";
    }

    @Override
    public void deleteById(Long id) {
        orderService.deleteById(id);
    }

    private OrderDtoGet addLinks(OrderDtoGet orderDtoGet) {
        orderDtoGet.add(
                linkTo(methodOn(OrderController.class).getAllOrders()).withRel("Orders"),
                linkTo(methodOn(OrderController.class).getOrderById(orderDtoGet.getId())).withRel("OrderId"),
                linkTo(methodOn(OrderController.class).getByUserId(orderDtoGet.getUser().getId())).withRel("UserId"),
                linkTo(methodOn(OrderController.class).getByProduceId(orderDtoGet.getProduce().getId())).withRel("ProduceId")
        );

        return orderDtoGet;
    }

    private List<OrderDtoGet> getUserAndProduceFromFeignClients(List<Order> orders) {
        List<OrderDtoGet> orderDtoGets = new ArrayList<>();

        orders.forEach(order -> {
            UserDto user = userFeign.getUserById(order.getUserId());
            ProduceDto produce = produceFeign.getById(order.getProduceId());

            orderDtoGets.add(orderMapper.orderToOrderDtoGet(order, user, produce));
        });

        return orderDtoGets.stream()
                .map(this::addLinks)
                .toList();
    }
}
