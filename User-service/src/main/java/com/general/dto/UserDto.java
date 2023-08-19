package com.general.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Pattern(regexp = "^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$", message = "{password.invalid.message}")
    @Size(max = 60, message = "{password.invalid.message}")
    @EqualsAndHashCode.Exclude
    private String password;

    private Boolean isActive;

    private String role;

    @Valid
    private UserDescriptionDto userDescription;

}
