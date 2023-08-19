package com.example.orderservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDescriptionDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String address;

}
