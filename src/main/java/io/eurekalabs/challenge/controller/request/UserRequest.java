package io.eurekalabs.challenge.controller.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank(message = "Username cannot be null or contains whitespace")
    private String username;

    @NotNull
    @Size(min = 4, max = 15, message = "Password must be between 4 and 15 characters")
    private String password;

    @NotBlank(message = "Name cannot be null or contains whitespace")
    private String name;

    @NotBlank(message = "Lastname cannot be null or contains whitespace")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;
}
