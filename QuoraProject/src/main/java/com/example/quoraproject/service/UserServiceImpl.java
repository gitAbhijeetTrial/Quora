package com.example.quoraproject.service;

import com.example.quoraproject.dto.UserRegistrationDTO;
import com.example.quoraproject.model.User;
import com.example.quoraproject.repository.TopicRepository;
import com.example.quoraproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public User registerUser(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setTopics(registrationDTO.getSelectedTopicNames().stream()
                .map(topicName -> topicRepository.findByName(topicName).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet()));

        return userRepository.save(user);
    }
}
