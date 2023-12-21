package com.example.quoraproject.service;

import com.example.quoraproject.model.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);

    Comment createComment(Comment comment,Long ansId);

    Comment updateComment(Long id, Comment updatedComment);

    boolean deleteComment(Long id);

    List<Comment> getCommentsForAnswer(Long answerId);
}

