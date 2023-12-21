package com.example.quoraproject.service;

import com.example.quoraproject.dto.UserRegistrationDTO;
import com.example.quoraproject.model.User;

import java.util.List;

public interface UserService {
    User registerUser(UserRegistrationDTO registrationDTO);
}

