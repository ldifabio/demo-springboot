package io.eurekalabs.challenge.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank
    private String username;

    @NotNull
    @Size(min = 4, max = 15)
    private String password;


}
