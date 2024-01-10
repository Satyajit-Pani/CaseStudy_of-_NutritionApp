package com.authentication.controller;


import com.authentication.config.Authenticate;
import com.authentication.dto.JwtRequest;
import com.authentication.dto.JwtResponse;
import com.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/authenticate")
public class UserController {

    private final UserService userService;
    private final Authenticate authenticate;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticate.authenticate(jwtRequest);
        jwtResponse.setJwtToken(userService.generateToken(jwtRequest.getUsername()));
        return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }
}
