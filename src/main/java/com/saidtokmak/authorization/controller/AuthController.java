package com.saidtokmak.authorization.controller;

import com.saidtokmak.authorization.config.JwtUtil;
import com.saidtokmak.authorization.dto.CreateUpdateUserRequest;
import com.saidtokmak.authorization.dto.LoginRequest;
import com.saidtokmak.authorization.dto.LoginResponse;
import com.saidtokmak.authorization.dto.UserDto;
import com.saidtokmak.authorization.entity.User;
import com.saidtokmak.authorization.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        User user = userService.search(request);
        if (user == null) {
            return new LoginResponse();
        }

        return LoginResponse.builder()
                .token("jwtUtil.generateToken(user)").build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody CreateUpdateUserRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
}
