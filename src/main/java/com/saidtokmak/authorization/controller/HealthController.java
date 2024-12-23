package com.saidtokmak.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {

    @GetMapping("/health")
    public boolean health() {
        return true;
    }

    @GetMapping("/user-role")
    public String user() {
        return "User role permitted!";
    }
}
