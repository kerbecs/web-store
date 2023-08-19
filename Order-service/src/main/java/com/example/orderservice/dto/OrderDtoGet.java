package com.example.orderservice.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDtoGet extends RepresentationModel<OrderDtoGet> {
    private Long id;

    private ProduceDto produce;

    private UserDto user;

    private LocalDateTime timeOrder;
}
