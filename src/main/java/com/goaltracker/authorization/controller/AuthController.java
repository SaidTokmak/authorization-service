package com.goaltracker.authorization.controller;

import com.goaltracker.authorization.dto.LoginRequest;
import com.goaltracker.authorization.dto.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return new LoginResponse();
    }
}
