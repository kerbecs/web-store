package com.general.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document("produces")
public class Produce {
    @Id
    private String id;
    private String name;
    private String description;
    private String country;
    private String brand;
    private Double price;
    private String deliveryPrice;
    private Integer quantity;

}
