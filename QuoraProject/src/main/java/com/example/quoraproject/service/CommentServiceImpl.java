package com.example.quoraproject.service;

import com.example.quoraproject.model.Answer;
import com.example.quoraproject.model.Comment;
import com.example.quoraproject.model.Question;
import com.example.quoraproject.model.User;
import com.example.quoraproject.repository.AnswerRepository;
import com.example.quoraproject.repository.CommentRepository;
import com.example.quoraproject.repository.QuestionRepository;
import com.example.quoraproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment request,Long ansId) {

        Comment newComment = new Comment();
        newComment.setContent(request.getContent());
        User user = userRepository.findById(request.getAuthor().getId()).orElse(null);
        Answer answer = answerRepository.findById(request.getAnswer().getId()).orElse(null);
        if (user != null && answer != null) {
            newComment.setAuthor(user);
            newComment.setAnswer(answer);
            commentRepository.save(newComment);
            return newComment;
        }
        return null;
    }

    @Override
    public Comment updateComment(Long id, Comment updatedComment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            existingComment.setContent(updatedComment.getContent());
            return commentRepository.save(existingComment);
        }
        return null;
    }

    @Override
    public boolean deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> getCommentsForAnswer(Long answerId) {
        return commentRepository.findByAnswerId(answerId);
    }
}

