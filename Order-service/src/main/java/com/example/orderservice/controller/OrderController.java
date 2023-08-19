package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDtoGet;
import com.example.orderservice.dto.OrderDtoSave;
import com.example.orderservice.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RefreshScope
public class OrderController {
    private final OrderFacade orderFacade;

    @GetMapping
    public ResponseEntity<List<OrderDtoGet>> getAllOrders() {
        return ResponseEntity.ok(orderFacade.getAllOrders());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OrderDtoGet> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderFacade.getOrderById(id));
    }

    @GetMapping("/produce/{id}")
    public ResponseEntity<List<OrderDtoGet>> getByProduceId(@PathVariable String id) {
        return ResponseEntity.ok(orderFacade.getByProduceId(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDtoGet>> getByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(orderFacade.getByUserId(id));
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody OrderDtoSave orderDtoSave) {
        orderFacade.saveOrder(orderDtoSave);

        return new ResponseEntity<>("Order was made", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderFacade.deleteById(id);
    }
}
