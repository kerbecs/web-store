package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produce_id", nullable = false, updatable = false)
    private String produceId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @DateTimeFormat
    @Column(name = "time_order", nullable = false, updatable = false)
    private LocalDateTime timeOrder;
}
