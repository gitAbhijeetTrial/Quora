package com.example.quoraproject.repository;

import com.example.quoraproject.dto.ContentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContentRepository extends JpaRepository<ContentDTO, Long> {

    @Query(nativeQuery = true, value = "SELECT q.questionId AS question_id, q.content AS question_content, a.ansId AS answer_id, a.content AS answer_content,c.commentId AS comment_id, c.content AS comment_content FROM Question q LEFT JOIN Ans a ON q.questionId = a.questionId Comment c ON a.ansId = c.ansId\n" +
            "INNER JOIN User u ON u.userId = q.userId WHERE u.topicId IN (SELECT topicId FROM UserTopicSubscription WHERE userId = ?)\n" +
            "ORDER BY question_id,answer_id, comment_id")
    Page<ContentDTO> findContentByUserAndTopics(Long userId, Pageable pageable);
}
