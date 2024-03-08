package com.goaltracker.authorization.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUpdateUserRequest {

    @NotBlank
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
