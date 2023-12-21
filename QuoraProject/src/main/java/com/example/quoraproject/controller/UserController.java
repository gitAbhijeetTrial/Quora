package com.example.quoraproject.controller;

import com.example.quoraproject.dto.UserRegistrationDTO;
import com.example.quoraproject.model.User;
import com.example.quoraproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {

        User user = userService.registerUser(registrationDTO);

        if (user != null) {
            // Successful registration
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } else {
            // Registration failed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }
    }
}
