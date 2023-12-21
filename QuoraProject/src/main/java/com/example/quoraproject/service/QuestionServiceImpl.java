package com.example.quoraproject.service;

import com.example.quoraproject.dto.QuestionCreationDTO;
import com.example.quoraproject.model.Question;
import com.example.quoraproject.model.User;
import com.example.quoraproject.repository.QuestionRepository;
import com.example.quoraproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionCreationDTO request) {

        Question newQuestion = new Question();
        newQuestion.setTitle(request.getTitle());
        newQuestion.setContent(request.getContent());
        User user = userRepository.findById(request.getUserId()).orElse(null);
        if (user != null) {
            newQuestion.setAuthor(user);
            questionRepository.save(newQuestion);
            return newQuestion;
        }
        return null;
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setTitle(updatedQuestion.getTitle());
            existingQuestion.setContent(updatedQuestion.getContent());
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    @Override
    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
