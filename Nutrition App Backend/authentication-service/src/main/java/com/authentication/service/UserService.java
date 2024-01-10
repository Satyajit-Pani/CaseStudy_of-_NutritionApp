package com.authentication.service;

import com.authentication.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public String generateToken(String username) {
        return jwtUtil.generateToken(userDetailsService.loadUserByUsername(username));
    }

}
