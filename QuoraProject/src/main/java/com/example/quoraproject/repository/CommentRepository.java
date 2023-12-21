package com.example.quoraproject.repository;

import com.example.quoraproject.model.Answer;
import com.example.quoraproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long> {

    @Query(nativeQuery = true, value = "SELECT a.content from answer a where a.questionId = ?")
    List<Comment> findByAnswerId(Long questionId);
}
