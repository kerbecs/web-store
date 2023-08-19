package com.example.orderservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDtoSave {
    private Long id;

    @NotNull(message = "{validation.notnull.message}")
    private String produceId;

    @NotNull(message = "{validation.notnull.message}")
    private Long userId;

    @Past(message = "{validation.date.message}")
    @NotNull(message = "{validation.notnull.message}")
    private LocalDateTime timeOrder;
}
