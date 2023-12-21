package com.example.quoraproject.repository;

import com.example.quoraproject.model.Topic;
import com.example.quoraproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByName(String name);
}
