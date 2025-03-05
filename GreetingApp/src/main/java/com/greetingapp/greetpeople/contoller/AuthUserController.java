package com.greetingapp.greetpeople.controller;

import com.greetingapp.greetpeople.model.AuthUser;
import com.greetingapp.greetpeople.service.AuthUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthUserService authUserService;

    public AuthUserController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    // **User Registration API**
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthUser user) {
        String response = authUserService.registerUser(user);
        if (response.equals("User registered successfully!")) {
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    // **User Login API**
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AuthUser user) {
        String response = authUserService.loginUser(user.getEmail(), user.getPassword());
        if (response.equals("Login successful!")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(response);
    }
}
