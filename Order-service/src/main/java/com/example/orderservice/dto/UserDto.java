package com.example.orderservice.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto extends RepresentationModel<UserDto> {
    private Long id;

    private String username;

    private String password;

    private Boolean isActive;

    private String role;

    private UserDescriptionDto userDescription;

}
