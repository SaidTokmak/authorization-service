package com.goaltracker.authorization.controller;

import com.goaltracker.authorization.dto.CreateUpdateUserRequest;
import com.goaltracker.authorization.dto.LoginRequest;
import com.goaltracker.authorization.dto.LoginResponse;
import com.goaltracker.authorization.dto.UserDto;
import com.goaltracker.authorization.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return new LoginResponse();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody CreateUpdateUserRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}
