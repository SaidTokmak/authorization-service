package com.saidtokmak.authorization.filter;

import com.saidtokmak.authorization.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  {

    private final JwtUtil jwtUtil;
}
