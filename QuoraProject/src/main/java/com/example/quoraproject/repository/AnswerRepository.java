package com.example.quoraproject.repository;

import com.example.quoraproject.dto.ContentDTO;
import com.example.quoraproject.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(nativeQuery = true, value = "SELECT a.content from answer a where a.questionId = ?")
    List<Answer> findByQuestionId(Long questionId);
}
