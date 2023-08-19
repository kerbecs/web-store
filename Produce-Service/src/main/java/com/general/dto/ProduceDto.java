package com.general.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduceDto extends RepresentationModel<ProduceDto> {
    private String id;

    @Size(min = 2, max = 70, message = "{validation.name.message}")
    @NotBlank(message = "{validation.required.message}")
    private String name;

    @NotBlank(message = "{validation.required.message}")
    @Size(min = 10, max = 250, message = "{validation.description.message}")
    private String description;

    @NotNull(message = "{validation.required.message}")
    @Pattern(regexp = "^[A-za-z ']$", message = "{validation.country.message}")
    private String country;

    @NotBlank(message = "{validation.required.message}")
    private String brand;

    @NotNull(message = "{validation.required.message}")
    @Min(value = 0, message = "{validation.price.message}")
    private Double price;

    @NotNull(message = "{validation.required.message}")
    @Min(value = 0, message = "{validation.deliveryPrice.message}")
    private Double deliveryPrice;

    @NotNull(message = "{validation.required.message}")
    @Min(value = 0, message = "{validation.quantity.message}")
    private Integer quantity;
}
