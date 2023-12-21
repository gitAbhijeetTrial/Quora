package com.example.quoraproject.repository;

import com.example.quoraproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
