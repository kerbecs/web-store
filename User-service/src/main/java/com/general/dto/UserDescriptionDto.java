package com.general.dto;

import com.general.annotation.Unique;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class UserDescriptionDto {
    private Integer id;

    @Pattern(regexp = "^([A-Za-z\']{2,25})$", message = "{firstName.invalid.message}")
    private String firstName;

    @Pattern(regexp = "^([A-Za-z\']{2,25})$", message = "{lastName.invalid.message}")
    private String lastName;

    @Email(message = "{email.invalid.message}")
    @NotEmpty(message = "{email.invalid.message}")
    @Unique(column = "email", table = "UserDescription", message = "{email.unique.message}")
    private String email;

    @Pattern(regexp = "^([A-Za-z\\-\\s\']{2,25})$", message = "{city.invalid.message}")
    private String city;

    @Pattern(regexp = "^([A-Za-z0-9\\s\\\\\'\\-]{5,70})$", message = "{address.invalid.message}")
    private String address;


}
