package com.authentication.controller;

import static org.mockito.Mockito.mock;

import com.authentication.config.Authenticate;
import com.authentication.dto.JwtRequest;
import com.authentication.repository.UserRepository;
import com.authentication.service.UserService;
import com.authentication.util.JwtUtil;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

class UserControllerTest {
    /**
     * Method under test: {@link UserController#login(JwtRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        JwtUtil jwtUtil = new JwtUtil(mock(UserRepository.class));
        UserService userService = new UserService(jwtUtil, new InMemoryUserDetailsManager());

        UserController userController = new UserController(userService,
                new Authenticate(new ProviderManager(new ArrayList<>())));

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("iloveyou");
        jwtRequest.setUsername("janedoe");
        userController.login(jwtRequest);
    }

    /**
     * Method under test: {@link UserController#login(JwtRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        Authenticate authenticate = new Authenticate(new ProviderManager(authenticationProviderList));
        JwtUtil jwtUtil = new JwtUtil(mock(UserRepository.class));
        UserController userController = new UserController(new UserService(jwtUtil, new InMemoryUserDetailsManager()),
                authenticate);

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("iloveyou");
        jwtRequest.setUsername("janedoe");
        userController.login(jwtRequest);
    }
}

