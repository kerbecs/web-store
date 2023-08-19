package com.example.orderservice.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduceDto extends RepresentationModel<ProduceDto> {
    private String id;

    private String name;

    private String description;

    private String country;

    private String brand;

    private Double price;

    private Double deliveryPrice;

    private Integer quantity;
}
